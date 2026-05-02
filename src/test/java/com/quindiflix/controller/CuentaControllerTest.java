package com.quindiflix.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.quindiflix.dto.CuentaDTO;
import com.quindiflix.mapper.CuentaMapper;
import com.quindiflix.model.Cuenta;
import com.quindiflix.service.CuentaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CuentaController.class)
class CuentaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private CuentaService service;

    @MockitoBean
    private CuentaMapper mapper;

    @Autowired
    private ObjectMapper objectMapper;

    private Cuenta cuenta;
    private CuentaDTO cuentaDTO;

    @BeforeEach
    void setUp() {
        objectMapper.registerModule(new JavaTimeModule());

        // Entidad simulada
        cuenta = Cuenta.builder()
                .idCuenta(1)
                .estadoServicio("ACTIVO")
                .fechaUltimoPago(LocalDate.now())
                .build();

        // DTO simulado
        cuentaDTO = new CuentaDTO();
        cuentaDTO.setIdCuenta(1);
        cuentaDTO.setEstadoServicio("ACTIVO");
        cuentaDTO.setFechaUltimoPago(LocalDate.now());
    }

    @Test
    void testFindAll() throws Exception {
        when(service.findAll()).thenReturn(List.of(cuenta));
        when(mapper.toDTO(any(Cuenta.class))).thenReturn(cuentaDTO);

        mockMvc.perform(get("/api/cuentas"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].idCuenta").value(1))
                .andExpect(jsonPath("$[0].estadoServicio").value("ACTIVO"));
    }

    @Test
    void testFindById_Success() throws Exception {
        when(service.findById(1)).thenReturn(Optional.of(cuenta));
        when(mapper.toDTO(cuenta)).thenReturn(cuentaDTO);

        mockMvc.perform(get("/api/cuentas/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idCuenta").value(1));
    }

    @Test
    void testCreate() throws Exception {
        // Simulamos: DTO -> Entity -> Save -> Entity -> DTO
        when(mapper.toEntity(any(CuentaDTO.class))).thenReturn(cuenta);
        when(service.save(any(Cuenta.class))).thenReturn(cuenta);
        when(mapper.toDTO(any(Cuenta.class))).thenReturn(cuentaDTO);

        mockMvc.perform(post("/api/cuentas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(cuentaDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idCuenta").value(1))
                .andExpect(jsonPath("$.estadoServicio").value("ACTIVO"));
    }

    @Test
    void testUpdate_Success() throws Exception {
        when(service.findById(1)).thenReturn(Optional.of(cuenta));
        when(mapper.toEntity(any(CuentaDTO.class))).thenReturn(cuenta);
        when(service.save(any(Cuenta.class))).thenReturn(cuenta);
        when(mapper.toDTO(any(Cuenta.class))).thenReturn(cuentaDTO);

        mockMvc.perform(put("/api/cuentas/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(cuentaDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idCuenta").value(1));
    }

    @Test
    void testDelete() throws Exception {
        mockMvc.perform(delete("/api/cuentas/1"))
                .andExpect(status().isNoContent());
    }
}