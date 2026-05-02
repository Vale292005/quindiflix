package com.quindiflix.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.quindiflix.dto.PagoDTO;
import com.quindiflix.service.PagoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean; // <-- CAMBIO: Importación para 3.3.0
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PagoController.class)
class PagoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean // <-- CAMBIO: De @MockitoBean a @MockBean
    private PagoService service;

    @Autowired
    private ObjectMapper objectMapper;

    private PagoDTO pagoDTO;

    @BeforeEach
    void setUp() {
        // Registro del módulo para manejar LocalDate en el JSON
        objectMapper.registerModule(new JavaTimeModule());

        pagoDTO = new PagoDTO();
        pagoDTO.setIdPago(1);
        pagoDTO.setFechaPago(LocalDate.now());
        pagoDTO.setMonto(new BigDecimal("29.99"));
        pagoDTO.setMetodoPago("TARJETA");
        pagoDTO.setEstadoPago("PROCESADO");
    }

    @Test
    void testFindAll() throws Exception {
        when(service.findAll()).thenReturn(List.of(pagoDTO));

        mockMvc.perform(get("/api/pagos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].idPago").value(1))
                .andExpect(jsonPath("$[0].monto").value(29.99));
    }

    @Test
    void testFindById_Found() throws Exception {
        when(service.findById(1)).thenReturn(Optional.of(pagoDTO));

        mockMvc.perform(get("/api/pagos/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.metodoPago").value("TARJETA"));
    }

    @Test
    void testFindById_NotFound() throws Exception {
        when(service.findById(99)).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/pagos/99"))
                .andExpect(status().isNotFound());
    }

    @Test
    void testCreate() throws Exception {
        when(service.save(any(PagoDTO.class))).thenReturn(pagoDTO);

        mockMvc.perform(post("/api/pagos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(pagoDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idPago").value(1))
                .andExpect(jsonPath("$.monto").value(29.99));
    }

    @Test
    void testUpdate_Success() throws Exception {
        when(service.findById(1)).thenReturn(Optional.of(pagoDTO));
        when(service.save(any(PagoDTO.class))).thenReturn(pagoDTO);

        mockMvc.perform(put("/api/pagos/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(pagoDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.estadoPago").value("PROCESADO"));
    }

    @Test
    void testUpdate_NotFound() throws Exception {
        when(service.findById(99)).thenReturn(Optional.empty());

        mockMvc.perform(put("/api/pagos/99")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(pagoDTO)))
                .andExpect(status().isNotFound());
    }

    @Test
    void testDelete() throws Exception {
        doNothing().when(service).deleteById(1);

        mockMvc.perform(delete("/api/pagos/1"))
                .andExpect(status().isNoContent());
    }
}