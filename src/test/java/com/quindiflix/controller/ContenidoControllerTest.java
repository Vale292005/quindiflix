package com.quindiflix.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.quindiflix.dto.ContenidoDTO;
import com.quindiflix.exception.BadRequestException;
import com.quindiflix.service.ContenidoService;
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

@WebMvcTest(ContenidoController.class)
class ContenidoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean // <-- CAMBIO: Usamos @MockBean
    private ContenidoService service;

    @Autowired
    private ObjectMapper objectMapper;

    private ContenidoDTO contenidoDTO;

    @BeforeEach
    void setUp() {
        // Soporte para LocalDate
        objectMapper.registerModule(new JavaTimeModule());

        contenidoDTO = new ContenidoDTO();
        contenidoDTO.setIdContenido(1);
        contenidoDTO.setTitulo("Stranger Things");
        contenidoDTO.setTipoContenido("Serie");
        contenidoDTO.setEsOriginal(true);
        contenidoDTO.setIdEmpleadoResponsable(10); 
    }

    @Test
    void testFindAll() throws Exception {
        when(service.findAll()).thenReturn(List.of(contenidoDTO));

        mockMvc.perform(get("/api/contenidos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].idContenido").value(1))
                .andExpect(jsonPath("$[0].titulo").value("Stranger Things"));
    }

    @Test
    void testFindById_Found() throws Exception {
        when(service.findById(1)).thenReturn(Optional.of(contenidoDTO));

        mockMvc.perform(get("/api/contenidos/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.titulo").value("Stranger Things"));
    }

    @Test
    void testFindById_NotFound() throws Exception {
        when(service.findById(99)).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/contenidos/99"))
                .andExpect(status().isNotFound());
    }

    @Test
    void testCreate_Success() throws Exception {
        when(service.save(any(ContenidoDTO.class))).thenReturn(contenidoDTO);

        mockMvc.perform(post("/api/contenidos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(contenidoDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.titulo").value("Stranger Things"));
    }

    @Test
    void testCreate_BadRequest_EmpleadoNoValido() throws Exception {
        when(service.save(any(ContenidoDTO.class)))
                .thenThrow(new BadRequestException("Debe asignar un empleado responsable al contenido."));

        mockMvc.perform(post("/api/contenidos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(contenidoDTO)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testUpdate_Success() throws Exception {
        when(service.update(eq(1), any(ContenidoDTO.class))).thenReturn(contenidoDTO);

        mockMvc.perform(put("/api/contenidos/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(contenidoDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idContenido").value(1));
    }

    @Test
    void testUpdate_NotFound() throws Exception {
        when(service.update(eq(99), any(ContenidoDTO.class)))
                .thenThrow(new RuntimeException("Contenido no encontrado"));

        mockMvc.perform(put("/api/contenidos/99")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(contenidoDTO)))
                .andExpect(status().isNotFound());
    }

    @Test
    void testDelete() throws Exception {
        doNothing().when(service).deleteById(1);

        mockMvc.perform(delete("/api/contenidos/1"))
                .andExpect(status().isNoContent());
    }
    
    @Test
    void testFindAllByPerfil_Infantil() throws Exception {
        when(service.findAllByPerfil(1)).thenReturn(List.of(contenidoDTO));

        mockMvc.perform(get("/api/contenidos/perfil/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }
}