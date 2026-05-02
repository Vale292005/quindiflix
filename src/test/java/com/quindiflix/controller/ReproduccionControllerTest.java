package com.quindiflix.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.quindiflix.dto.ReproduccionDTO;
import com.quindiflix.service.ReproduccionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean; // <-- CAMBIO: Importación correcta para 3.3.0
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ReproduccionController.class)
class ReproduccionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean // <-- CAMBIO: De @MockitoBean a @MockBean
    private ReproduccionService service;

    @Autowired
    private ObjectMapper objectMapper;

    private ReproduccionDTO reproduccionDTO;

    @BeforeEach
    void setUp() {
        // Vital para manejar LocalDateTime correctamente en el JSON
        objectMapper.registerModule(new JavaTimeModule());

        reproduccionDTO = new ReproduccionDTO();
        reproduccionDTO.setIdReproduccion(1);
        reproduccionDTO.setFechaHoraInicio(LocalDateTime.now().minusHours(1));
        reproduccionDTO.setFechaHoraFin(LocalDateTime.now());
        reproduccionDTO.setDispositivo("Smart TV Samsung");
        reproduccionDTO.setPorcentajeAvance(new BigDecimal("75.50"));
    }

    @Test
    void testFindAll() throws Exception {
        when(service.findAll()).thenReturn(List.of(reproduccionDTO));

        mockMvc.perform(get("/api/reproducciones"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].idReproduccion").value(1))
                .andExpect(jsonPath("$[0].dispositivo").value("Smart TV Samsung"))
                .andExpect(jsonPath("$[0].porcentajeAvance").value(75.50));
    }

    @Test
    void testFindById_Found() throws Exception {
        when(service.findById(1)).thenReturn(Optional.of(reproduccionDTO));

        mockMvc.perform(get("/api/reproducciones/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idReproduccion").value(1));
    }

    @Test
    void testFindById_NotFound() throws Exception {
        when(service.findById(99)).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/reproducciones/99"))
                .andExpect(status().isNotFound());
    }

    @Test
    void testCreate() throws Exception {
        when(service.save(any(ReproduccionDTO.class))).thenReturn(reproduccionDTO);

        mockMvc.perform(post("/api/reproducciones")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(reproduccionDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.porcentajeAvance").value(75.50));
    }

    @Test
    void testUpdate_Success() throws Exception {
        // Doble mock para simular el flujo completo
        when(service.findById(1)).thenReturn(Optional.of(reproduccionDTO));
        when(service.save(any(ReproduccionDTO.class))).thenReturn(reproduccionDTO);

        mockMvc.perform(put("/api/reproducciones/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(reproduccionDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idReproduccion").value(1));
    }

    @Test
    void testUpdate_NotFound() throws Exception {
        when(service.findById(99)).thenReturn(Optional.empty());

        mockMvc.perform(put("/api/reproducciones/99")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(reproduccionDTO)))
                .andExpect(status().isNotFound());
    }

    @Test
    void testDelete() throws Exception {
        doNothing().when(service).deleteById(1);

        mockMvc.perform(delete("/api/reproducciones/1"))
                .andExpect(status().isNoContent());
    }
}