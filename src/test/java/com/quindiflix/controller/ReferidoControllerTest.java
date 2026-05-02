package com.quindiflix.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.quindiflix.dto.ReferidoDTO;
import com.quindiflix.exception.BadRequestException;
import com.quindiflix.service.ReferidoService;
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
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ReferidoController.class)
class ReferidoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean // <-- CAMBIO: De @MockitoBean a @MockBean
    private ReferidoService service;

    @Autowired
    private ObjectMapper objectMapper;

    private ReferidoDTO referidoDTO;

    @BeforeEach
    void setUp() {
        objectMapper.registerModule(new JavaTimeModule());

        referidoDTO = new ReferidoDTO();
        referidoDTO.setIdReferido(1);
        referidoDTO.setFechaRegistro(LocalDate.now());
        referidoDTO.setActivo(true);
        referidoDTO.setIdUsuarioReferidor(10);
        referidoDTO.setIdUsuarioReferido(20);
    }

    @Test
    void testFindAll() throws Exception {
        when(service.findAll()).thenReturn(List.of(referidoDTO));

        mockMvc.perform(get("/api/referidos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].idReferido").value(1));
    }

    @Test
    void testFindById_Found() throws Exception {
        when(service.findById(1)).thenReturn(Optional.of(referidoDTO));

        mockMvc.perform(get("/api/referidos/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idReferido").value(1));
    }

    @Test
    void testCreate_Success() throws Exception {
        when(service.save(any(ReferidoDTO.class))).thenReturn(referidoDTO);

        mockMvc.perform(post("/api/referidos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(referidoDTO)))
                .andExpect(status().isOk());
    }

    @Test
    void testUpdate_Success() throws Exception {
        when(service.update(eq(1), any(ReferidoDTO.class))).thenReturn(referidoDTO);

        mockMvc.perform(put("/api/referidos/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(referidoDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idReferido").value(1));
    }

    @Test
    void testUpdate_BadRequest_AutoReferencia() throws Exception {
        when(service.update(eq(1), any(ReferidoDTO.class)))
                .thenThrow(new BadRequestException("Un usuario no puede referirse a sí mismo."));

        mockMvc.perform(put("/api/referidos/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(referidoDTO)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testUpdate_NotFound() throws Exception {
        when(service.update(eq(99), any(ReferidoDTO.class)))
                .thenThrow(new RuntimeException("Referido no encontrado"));

        mockMvc.perform(put("/api/referidos/99")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(referidoDTO)))
                .andExpect(status().isNotFound());
    }

    @Test
    void testDelete() throws Exception {
        doNothing().when(service).deleteById(1);

        mockMvc.perform(delete("/api/referidos/1"))
                .andExpect(status().isNoContent());
    }

    @Test
    void testAplicarDescuento_Success() throws Exception {
        // Mantenemos el nombre del método "plicarDescuento" según tu lógica de service
        doNothing().when(service).plicarDescuento(1, 10);

        mockMvc.perform(post("/api/referidos/1/aplicar-descuento/10"))
                .andExpect(status().isOk());
        
        verify(service, times(1)).plicarDescuento(1, 10);
    }

    @Test
    void testAplicarDescuento_NotFound() throws Exception {
        doThrow(new RuntimeException("Referido no encontrado"))
                .when(service).plicarDescuento(99, 10);

        mockMvc.perform(post("/api/referidos/99/aplicar-descuento/10"))
                .andExpect(status().isNotFound());
    }
}