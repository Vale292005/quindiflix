package com.quindiflix.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.quindiflix.dto.TemporadaDTO;
import com.quindiflix.exception.BadRequestException;
import com.quindiflix.service.TemporadaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean; // <-- CAMBIO: Importación para 3.3.0
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TemporadaController.class)
class TemporadaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean // <-- CAMBIO: De @MockitoBean a @MockBean
    private TemporadaService service;

    @Autowired
    private ObjectMapper objectMapper;

    private TemporadaDTO temporadaDTO;

    @BeforeEach
    void setUp() {
        temporadaDTO = new TemporadaDTO();
        temporadaDTO.setIdTemporada(1);
        temporadaDTO.setNumeroTemporada(1);
        temporadaDTO.setTitulo("El despertar de los datos");
        temporadaDTO.setIdContenido(10); // ID de la Serie/Pódcast
    }

    @Test
    void testFindAll() throws Exception {
        when(service.findAll()).thenReturn(List.of(temporadaDTO));

        mockMvc.perform(get("/api/temporadas"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].idTemporada").value(1))
                .andExpect(jsonPath("$[0].titulo").value("El despertar de los datos"));
    }

    @Test
    void testFindById_Found() throws Exception {
        when(service.findById(1)).thenReturn(Optional.of(temporadaDTO));

        mockMvc.perform(get("/api/temporadas/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.titulo").value("El despertar de los datos"));
    }

    @Test
    void testFindById_NotFound() throws Exception {
        when(service.findById(99)).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/temporadas/99"))
                .andExpect(status().isNotFound());
    }

    @Test
    void testCreate_Success() throws Exception {
        when(service.save(any(TemporadaDTO.class))).thenReturn(temporadaDTO);

        mockMvc.perform(post("/api/temporadas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(temporadaDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idTemporada").value(1));
    }

    @Test
    void testUpdate_Success() throws Exception {
        when(service.update(eq(1), any(TemporadaDTO.class))).thenReturn(temporadaDTO);

        mockMvc.perform(put("/api/temporadas/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(temporadaDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.numeroTemporada").value(1));
    }

    @Test
    void testUpdate_BadRequest_TipoInvalido() throws Exception {
        // Simulamos el error de asignar temporadas a una Película
        when(service.update(eq(1), any(TemporadaDTO.class)))
                .thenThrow(new BadRequestException("No se puede crear una temporada para un contenido de tipo: Pelicula"));

        mockMvc.perform(put("/api/temporadas/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(temporadaDTO)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testUpdate_NotFound() throws Exception {
        when(service.update(eq(99), any(TemporadaDTO.class)))
                .thenThrow(new RuntimeException("Temporada no encontrada con id: 99"));

        mockMvc.perform(put("/api/temporadas/99")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(temporadaDTO)))
                .andExpect(status().isNotFound());
    }

    @Test
    void testDelete() throws Exception {
        doNothing().when(service).deleteById(1);

        mockMvc.perform(delete("/api/temporadas/1"))
                .andExpect(status().isNoContent());
    }
}