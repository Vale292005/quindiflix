package com.quindiflix.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.quindiflix.dto.GeneroDTO;
import com.quindiflix.service.GeneroService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean; // <-- CAMBIO: Importación correcta 3.3.0
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(GeneroController.class)
class GeneroControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean // <-- CAMBIO: De @MockitoBean a @MockBean
    private GeneroService service;

    @Autowired
    private ObjectMapper objectMapper;

    private GeneroDTO generoDTO;

    @BeforeEach
    void setUp() {
        generoDTO = new GeneroDTO();
        generoDTO.setIdGenero(1);
        generoDTO.setNombre("Ciencia Ficción");
    }

    @Test
    void testFindAll() throws Exception {
        when(service.findAll()).thenReturn(List.of(generoDTO));

        mockMvc.perform(get("/api/generos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].idGenero").value(1))
                .andExpect(jsonPath("$[0].nombre").value("Ciencia Ficción"));
    }

    @Test
    void testFindById_Found() throws Exception {
        when(service.findById(1)).thenReturn(Optional.of(generoDTO));

        mockMvc.perform(get("/api/generos/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre").value("Ciencia Ficción"));
    }

    @Test
    void testFindById_NotFound() throws Exception {
        when(service.findById(99)).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/generos/99"))
                .andExpect(status().isNotFound());
    }

    @Test
    void testCreate() throws Exception {
        when(service.save(any(GeneroDTO.class))).thenReturn(generoDTO);

        mockMvc.perform(post("/api/generos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(generoDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre").value("Ciencia Ficción"));
    }

    @Test
    void testUpdate_Success() throws Exception {
        when(service.findById(1)).thenReturn(Optional.of(generoDTO));
        when(service.save(any(GeneroDTO.class))).thenReturn(generoDTO);

        mockMvc.perform(put("/api/generos/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(generoDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idGenero").value(1));
    }

    @Test
    void testUpdate_NotFound() throws Exception {
        when(service.findById(99)).thenReturn(Optional.empty());

        mockMvc.perform(put("/api/generos/99")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(generoDTO)))
                .andExpect(status().isNotFound());
    }

    @Test
    void testDelete() throws Exception {
        doNothing().when(service).deleteById(1);

        mockMvc.perform(delete("/api/generos/1"))
                .andExpect(status().isNoContent());
    }
}