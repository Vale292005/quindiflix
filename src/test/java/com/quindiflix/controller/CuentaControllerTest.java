package com.quindiflix.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.quindiflix.dto.CuentaDTO;
import com.quindiflix.service.CuentaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean; // <-- CAMBIO: Importación para 3.3.0
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CuentaController.class)
class CuentaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean // <-- CAMBIO: Usamos @MockBean en lugar de @MockitoBean
    private CuentaService service;

    @Autowired
    private ObjectMapper objectMapper;

    private CuentaDTO cuentaDTO;

    @BeforeEach
    void setUp() {
        // Registro de módulo para manejar LocalDate en el JSON
        objectMapper.registerModule(new JavaTimeModule());

        cuentaDTO = new CuentaDTO();
        cuentaDTO.setIdCuenta(1);
        cuentaDTO.setEstadoServicio("ACTIVO");
        cuentaDTO.setFechaUltimoPago(LocalDate.now());
    }

    @Test
    void testFindAll() throws Exception {
        when(service.findAll()).thenReturn(List.of(cuentaDTO));

        mockMvc.perform(get("/api/cuentas"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].idCuenta").value(1))
                .andExpect(jsonPath("$[0].estadoServicio").value("ACTIVO"));
    }

    @Test
    void testFindById_Found() throws Exception {
        when(service.findById(1)).thenReturn(Optional.of(cuentaDTO));

        mockMvc.perform(get("/api/cuentas/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.estadoServicio").value("ACTIVO"));
    }

    @Test
    void testFindById_NotFound() throws Exception {
        when(service.findById(99)).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/cuentas/99"))
                .andExpect(status().isNotFound());
    }

    @Test
    void testCreate() throws Exception {
        when(service.save(any(CuentaDTO.class))).thenReturn(cuentaDTO);

        mockMvc.perform(post("/api/cuentas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(cuentaDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idCuenta").value(1));
    }

    @Test
    void testUpdate_Success() throws Exception {
        // Para que el update funcione, simulamos que existe y se guarda
        when(service.findById(1)).thenReturn(Optional.of(cuentaDTO));
        when(service.save(any(CuentaDTO.class))).thenReturn(cuentaDTO);

        mockMvc.perform(put("/api/cuentas/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(cuentaDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.estadoServicio").value("ACTIVO"));
    }

    @Test
    void testUpdate_NotFound() throws Exception {
        when(service.findById(99)).thenReturn(Optional.empty());

        mockMvc.perform(put("/api/cuentas/99")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(cuentaDTO)))
                .andExpect(status().isNotFound());
    }

    @Test
    void testDelete() throws Exception {
        doNothing().when(service).deleteById(1);

        mockMvc.perform(delete("/api/cuentas/1"))
                .andExpect(status().isNoContent());
    }
}