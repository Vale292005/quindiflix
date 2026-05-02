package com.quindiflix.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.quindiflix.model.Favorito;
import com.quindiflix.service.FavoritoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
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

    @MockitoBean
    private FavoritoService service;

    @Autowired
    private ObjectMapper objectMapper;

    private Favorito favorito;

    @BeforeEach
    void setUp() {
        // Importante para que Jackson entienda LocalDateTime
        objectMapper.registerModule(new JavaTimeModule());

        favorito = Favorito.builder()
                .idFavorito(1)
                .fecha(LocalDateTime.now())
                .build();
    }

    @Test
    void testFindAll() throws Exception {
        when(service.findAll()).thenReturn(List.of(favorito));

        mockMvc.perform(get("/api/favoritos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].idFavorito").value(1));
    }

    @Test
    void testFindById_Found() throws Exception {
        when(service.findById(1)).thenReturn(Optional.of(favorito));

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
        when(service.save(any(Favorito.class))).thenReturn(favorito);

        mockMvc.perform(post("/api/favoritos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(favorito)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idFavorito").value(1));
    }

    @Test
    void testUpdate_Success() throws Exception {
        when(service.findById(1)).thenReturn(Optional.of(favorito));
        when(service.save(any(Favorito.class))).thenReturn(favorito);

        mockMvc.perform(put("/api/favoritos/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(favorito)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idFavorito").value(1));
    }

    @Test
    void testDelete() throws Exception {
        doNothing().when(service).deleteById(1);

        mockMvc.perform(delete("/api/favoritos/1"))
                .andExpect(status().isNoContent());
    }
}