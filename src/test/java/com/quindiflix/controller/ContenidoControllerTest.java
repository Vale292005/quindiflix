package com.quindiflix.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.quindiflix.model.Contenido;
import com.quindiflix.service.ContenidoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ContenidoController.class)
class ContenidoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ContenidoService service;

    @Autowired
    private ObjectMapper objectMapper;

    private Contenido contenido;

    @BeforeEach
    void setUp() {
        // Registramos el módulo para manejar LocalDate si no está configurado globalmente
        objectMapper.registerModule(new JavaTimeModule());

        contenido = Contenido.builder()
                .idContenido(1)
                .titulo("Stranger Things")
                .fechaIncorporacion(LocalDate.now())
                .tipoContenido("Serie")
                .esOriginal(true)
                .temporadas(new ArrayList<>())
                .generos(new ArrayList<>())
                .build();
    }

    @Test
    void testFindAll() throws Exception {
        when(service.findAll()).thenReturn(List.of(contenido));

        mockMvc.perform(get("/api/contenidos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].titulo").value("Stranger Things"))
                .andExpect(jsonPath("$[0].esOriginal").value(true));
    }

    @Test
    void testFindById_Found() throws Exception {
        when(service.findById(1)).thenReturn(Optional.of(contenido));

        mockMvc.perform(get("/api/contenidos/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.titulo").value("Stranger Things"));
    }

    @Test
    void testCreate() throws Exception {
        when(service.save(any(Contenido.class))).thenReturn(contenido);

        mockMvc.perform(post("/api/contenidos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(contenido)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.titulo").value("Stranger Things"));
    }

    @Test
    void testUpdate_Success() throws Exception {
        when(service.findById(1)).thenReturn(Optional.of(contenido));
        when(service.save(any(Contenido.class))).thenReturn(contenido);

        mockMvc.perform(put("/api/contenidos/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(contenido)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idContenido").value(1));
    }

    @Test
    void testDelete() throws Exception {
        doNothing().when(service).deleteById(1);

        mockMvc.perform(delete("/api/contenidos/1"))
                .andExpect(status().isNoContent());
    }
}