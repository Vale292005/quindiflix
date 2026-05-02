package com.quindiflix.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.quindiflix.dto.ReferidoDTO;
import com.quindiflix.service.ReferidoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ReferidoController.class)
public class ReferidoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ReferidoService service;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testFindAll() throws Exception {
        ReferidoDTO dto1 = new ReferidoDTO(1, LocalDate.now());
        ReferidoDTO dto2 = new ReferidoDTO(2, LocalDate.now());

        when(service.findAll()).thenReturn(Arrays.asList(dto1, dto2));

        mockMvc.perform(get("/api/referidos"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()").value(2));
    }

    @Test
    public void testFindById() throws Exception {
        ReferidoDTO dto = new ReferidoDTO(1, LocalDate.now());

        when(service.findById(1)).thenReturn(Optional.of(dto));

        mockMvc.perform(get("/api/referidos/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.idReferido").value(1));
    }

    @Test
    public void testFindByIdNotFound() throws Exception {
        when(service.findById(1)).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/referidos/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testCreate() throws Exception {
        ReferidoDTO dto = new ReferidoDTO(null, LocalDate.now());
        ReferidoDTO savedDto = new ReferidoDTO(1, LocalDate.now());

        when(service.save(any())).thenReturn(savedDto);

        mockMvc.perform(post("/api/referidos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idReferido").value(1));
    }

    @Test
    public void testUpdate() throws Exception {
        ReferidoDTO dto = new ReferidoDTO(1, LocalDate.now());

        when(service.findById(1)).thenReturn(Optional.of(dto));
        when(service.save(any())).thenReturn(dto);

        mockMvc.perform(put("/api/referidos/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idReferido").value(1));
    }

    @Test
    public void testUpdateNotFound() throws Exception {
        ReferidoDTO dto = new ReferidoDTO(1, LocalDate.now());

        when(service.findById(1)).thenReturn(Optional.empty());

        mockMvc.perform(put("/api/referidos/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testDelete() throws Exception {
        doNothing().when(service).deleteById(1);

        mockMvc.perform(delete("/api/referidos/1"))
                .andExpect(status().isNoContent());

        verify(service, times(1)).deleteById(1);
    }
}
