package com.quindiflix.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.quindiflix.dto.PlanDTO;
import com.quindiflix.service.PlanService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PlanController.class)
public class PlanControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PlanService service;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testFindAll() throws Exception {
        PlanDTO dto1 = new PlanDTO(1, "Plan Básico", BigDecimal.valueOf(9.99), "Descripción Básica");
        PlanDTO dto2 = new PlanDTO(2, "Plan Premium", BigDecimal.valueOf(19.99), "Descripción Premium");

        when(service.findAll()).thenReturn(Arrays.asList(dto1, dto2));

        mockMvc.perform(get("/api/planes"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()").value(2));
    }

    @Test
    public void testFindById() throws Exception {
        PlanDTO dto = new PlanDTO(1, "Plan Básico", BigDecimal.valueOf(9.99), "Descripción Básica");

        when(service.findById(1)).thenReturn(Optional.of(dto));

        mockMvc.perform(get("/api/planes/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.idPlan").value(1));
    }

    @Test
    public void testFindByIdNotFound() throws Exception {
        when(service.findById(1)).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/planes/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testCreate() throws Exception {
        PlanDTO dto = new PlanDTO(null, "Nuevo Plan", BigDecimal.valueOf(14.99), "Nueva Descripción");
        PlanDTO savedDto = new PlanDTO(1, "Nuevo Plan", BigDecimal.valueOf(14.99), "Nueva Descripción");

        when(service.save(any())).thenReturn(savedDto);

        mockMvc.perform(post("/api/planes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idPlan").value(1));
    }

    @Test
    public void testUpdate() throws Exception {
        PlanDTO dto = new PlanDTO(1, "Plan Actualizado", BigDecimal.valueOf(24.99), "Descripción Actualizada");

        when(service.findById(1)).thenReturn(Optional.of(dto));
        when(service.save(any())).thenReturn(dto);

        mockMvc.perform(put("/api/planes/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.precio").value(24.99));
    }

    @Test
    public void testUpdateNotFound() throws Exception {
        PlanDTO dto = new PlanDTO(1, "Plan", BigDecimal.valueOf(9.99), "Descripción");

        when(service.findById(1)).thenReturn(Optional.empty());

        mockMvc.perform(put("/api/planes/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testDelete() throws Exception {
        doNothing().when(service).deleteById(1);

        mockMvc.perform(delete("/api/planes/1"))
                .andExpect(status().isNoContent());

        verify(service, times(1)).deleteById(1);
    }
}
