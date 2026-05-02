package com.quindiflix.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.quindiflix.dto.ReproduccionDTO;
import com.quindiflix.service.ReproduccionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ReproduccionController.class)
public class ReproduccionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ReproduccionService service;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testFindAll() throws Exception {
        ReproduccionDTO dto1 = new ReproduccionDTO(1, LocalDateTime.now(), 30);
        ReproduccionDTO dto2 = new ReproduccionDTO(2, LocalDateTime.now(), 45);

        when(service.findAll()).thenReturn(Arrays.asList(dto1, dto2));

        mockMvc.perform(get("/api/reproducciones"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()").value(2));
    }

    @Test
    public void testFindById() throws Exception {
        ReproduccionDTO dto = new ReproduccionDTO(1, LocalDateTime.now(), 30);

        when(service.findById(1)).thenReturn(Optional.of(dto));

        mockMvc.perform(get("/api/reproducciones/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.idReproduccion").value(1));
    }

    @Test
    public void testFindByIdNotFound() throws Exception {
        when(service.findById(1)).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/reproducciones/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testCreate() throws Exception {
        ReproduccionDTO dto = new ReproduccionDTO(null, LocalDateTime.now(), 60);
        ReproduccionDTO savedDto = new ReproduccionDTO(1, LocalDateTime.now(), 60);

        when(service.save(any())).thenReturn(savedDto);

        mockMvc.perform(post("/api/reproducciones")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idReproduccion").value(1));
    }

    @Test
    public void testUpdate() throws Exception {
        ReproduccionDTO dto = new ReproduccionDTO(1, LocalDateTime.now(), 50);

        when(service.findById(1)).thenReturn(Optional.of(dto));
        when(service.save(any())).thenReturn(dto);

        mockMvc.perform(put("/api/reproducciones/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.duracion").value(50));
    }

    @Test
    public void testUpdateNotFound() throws Exception {
        ReproduccionDTO dto = new ReproduccionDTO(1, LocalDateTime.now(), 30);

        when(service.findById(1)).thenReturn(Optional.empty());

        mockMvc.perform(put("/api/reproducciones/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testDelete() throws Exception {
        doNothing().when(service).deleteById(1);

        mockMvc.perform(delete("/api/reproducciones/1"))
                .andExpect(status().isNoContent());

        verify(service, times(1)).deleteById(1);
    }
}
