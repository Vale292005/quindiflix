package com.quindiflix.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.quindiflix.dto.FavoritoDTO;
import com.quindiflix.service.FavoritoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean; // <-- CAMBIO: Importación correcta para 3.3.0
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(FavoritoController.class)
class FavoritoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean // <-- CAMBIO: De @MockitoBean a @MockBean
    private FavoritoService service;

    @Autowired
    private ObjectMapper objectMapper;

    private FavoritoDTO favoritoDTO;

    @BeforeEach
    void setUp() {
        // Registro del módulo para manejar LocalDateTime en el JSON
        objectMapper.registerModule(new JavaTimeModule());

        favoritoDTO = new FavoritoDTO();
        favoritoDTO.setIdFavorito(1);
        favoritoDTO.setFecha(LocalDateTime.now());
    }

    @Test
    void testFindAll() throws Exception {
        when(service.findAll()).thenReturn(List.of(favoritoDTO));

        mockMvc.perform(get("/api/favoritos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].idFavorito").value(1));
    }

    @Test
    void testFindById_Found() throws Exception {
        when(service.findById(1)).thenReturn(Optional.of(favoritoDTO));

        mockMvc.perform(get("/api/favoritos/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idFavorito").value(1));
    }

    @Test
    void testFindById_NotFound() throws Exception {
        when(service.findById(99)).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/favoritos/99"))
                .andExpect(status().isNotFound());
    }

    @Test
    void testCreate() throws Exception {
        when(service.save(any(FavoritoDTO.class))).thenReturn(favoritoDTO);

        mockMvc.perform(post("/api/favoritos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(favoritoDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idFavorito").value(1));
    }

    @Test
    void testUpdate_Success() throws Exception {
        when(service.findById(1)).thenReturn(Optional.of(favoritoDTO));
        when(service.save(any(FavoritoDTO.class))).thenReturn(favoritoDTO);

        mockMvc.perform(put("/api/favoritos/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(favoritoDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idFavorito").value(1));
    }

    @Test
    void testUpdate_NotFound() throws Exception {
        when(service.findById(99)).thenReturn(Optional.empty());

        mockMvc.perform(put("/api/favoritos/99")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(favoritoDTO)))
                .andExpect(status().isNotFound());
    }

    @Test
    void testDelete() throws Exception {
        doNothing().when(service).deleteById(1);

        mockMvc.perform(delete("/api/favoritos/1"))
                .andExpect(status().isNoContent());
    }
}