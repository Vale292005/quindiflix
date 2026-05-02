package com.quindiflix.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.quindiflix.dto.PlanDTO;
import com.quindiflix.service.PlanService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean; // <-- CAMBIO: Importación para 3.3.0
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PlanController.class)
class PlanControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean // <-- CAMBIO: De @MockitoBean a @MockBean
    private PlanService service;

    @Autowired
    private ObjectMapper objectMapper;

    private PlanDTO planDTO;

    @BeforeEach
    void setUp() {
        planDTO = new PlanDTO();
        planDTO.setIdPlan(1);
        planDTO.setNombrePlan("Premium Ultra");
        planDTO.setPrecio(new BigDecimal("45900.00"));
        planDTO.setCalidadVideo("4K + HDR");
        planDTO.setCantidadPantallas(4);
        planDTO.setPerfilesPermitidos(5);
    }

    @Test
    void testFindAll() throws Exception {
        when(service.findAll()).thenReturn(List.of(planDTO));

        mockMvc.perform(get("/api/planes"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].idPlan").value(1))
                .andExpect(jsonPath("$[0].nombrePlan").value("Premium Ultra"))
                .andExpect(jsonPath("$[0].precio").value(45900.00));
    }

    @Test
    void testFindById_Found() throws Exception {
        when(service.findById(1)).thenReturn(Optional.of(planDTO));

        mockMvc.perform(get("/api/planes/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.calidadVideo").value("4K + HDR"));
    }

    @Test
    void testFindById_NotFound() throws Exception {
        when(service.findById(99)).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/planes/99"))
                .andExpect(status().isNotFound());
    }

    @Test
    void testCreate() throws Exception {
        when(service.save(any(PlanDTO.class))).thenReturn(planDTO);

        mockMvc.perform(post("/api/planes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(planDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombrePlan").value("Premium Ultra"));
    }

    @Test
    void testUpdate_Success() throws Exception {
        // Doble mock para el flujo de actualización
        when(service.findById(1)).thenReturn(Optional.of(planDTO));
        when(service.save(any(PlanDTO.class))).thenReturn(planDTO);

        mockMvc.perform(put("/api/planes/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(planDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idPlan").value(1));
    }

    @Test
    void testDelete() throws Exception {
        doNothing().when(service).deleteById(1);

        mockMvc.perform(delete("/api/planes/1"))
                .andExpect(status().isNoContent());
    }
}