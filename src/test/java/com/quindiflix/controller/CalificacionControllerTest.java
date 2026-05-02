package com.quindiflix.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.quindiflix.model.Calificacion;
import com.quindiflix.service.CalificacionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean; // <-- La nueva ruta
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CalificacionController.class)
public class CalificacionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean // <-- Reemplaza a @MockBean
    private CalificacionService service;

    @Autowired
    private ObjectMapper objectMapper;

    private Calificacion calificacion;

    @BeforeEach
    void setUp() {
        calificacion = new Calificacion();
        calificacion.setIdCalificacion(1);
        calificacion.setEstrellas(5);
    }

    @Test
    void testFindAll() throws Exception {
        when(service.findAll()).thenReturn(Arrays.asList(calificacion));

        mockMvc.perform(get("/api/calificaciones"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].idCalificacion").value(1))
                .andExpect(jsonPath("$[0].estrellas").value(5));
    }

    @Test
    void testFindById_Found() throws Exception {
        when(service.findById(1)).thenReturn(Optional.of(calificacion));

        mockMvc.perform(get("/api/calificaciones/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idCalificacion").value(1));
    }

    @Test
    void testCreate() throws Exception {
        when(service.save(any(Calificacion.class))).thenReturn(calificacion);

        mockMvc.perform(post("/api/calificaciones")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(calificacion)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idCalificacion").value(1));
    }

    @Test
    void testDelete() throws Exception {
        doNothing().when(service).deleteById(1);

        mockMvc.perform(delete("/api/calificaciones/1"))
                .andExpect(status().isNoContent());
    }
}