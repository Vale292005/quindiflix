package com.quindiflix.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.quindiflix.dto.TemporadaDTO;
import com.quindiflix.service.TemporadaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TemporadaController.class)
public class TemporadaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TemporadaService service;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testFindAll() throws Exception {
        TemporadaDTO dto1 = new TemporadaDTO(1, 1, "Temporada 1");
        TemporadaDTO dto2 = new TemporadaDTO(2, 2, "Temporada 2");

        when(service.findAll()).thenReturn(Arrays.asList(dto1, dto2));

        mockMvc.perform(get("/api/temporadas"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()").value(2));
    }

    @Test
    public void testFindById() throws Exception {
        TemporadaDTO dto = new TemporadaDTO(1, 1, "Temporada 1");

        when(service.findById(1)).thenReturn(Optional.of(dto));

        mockMvc.perform(get("/api/temporadas/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.idTemporada").value(1));
    }

    @Test
    public void testFindByIdNotFound() throws Exception {
        when(service.findById(1)).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/temporadas/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testCreate() throws Exception {
        TemporadaDTO dto = new TemporadaDTO(null, 1, "Nueva Temporada");
        TemporadaDTO savedDto = new TemporadaDTO(1, 1, "Nueva Temporada");

        when(service.save(any())).thenReturn(savedDto);

        mockMvc.perform(post("/api/temporadas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idTemporada").value(1));
    }

    @Test
    public void testUpdate() throws Exception {
        TemporadaDTO dto = new TemporadaDTO(1, 1, "Temporada Actualizada");

        when(service.findById(1)).thenReturn(Optional.of(dto));
        when(service.save(any())).thenReturn(dto);

        mockMvc.perform(put("/api/temporadas/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.titulo").value("Temporada Actualizada"));
    }

    @Test
    public void testUpdateNotFound() throws Exception {
        TemporadaDTO dto = new TemporadaDTO(1, 1, "Temporada");

        when(service.findById(1)).thenReturn(Optional.empty());

        mockMvc.perform(put("/api/temporadas/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testDelete() throws Exception {
        doNothing().when(service).deleteById(1);

        mockMvc.perform(delete("/api/temporadas/1"))
                .andExpect(status().isNoContent());

        verify(service, times(1)).deleteById(1);
    }
}
