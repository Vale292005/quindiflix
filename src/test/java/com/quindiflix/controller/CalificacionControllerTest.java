package com.quindiflix.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.quindiflix.dto.CalificacionDTO;
import com.quindiflix.security.JwtService;
import com.quindiflix.service.CalificacionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean; // <--- CAMBIO DE IMPORT
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = CalificacionController.class, excludeAutoConfiguration = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
        org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration.class
})
class CalificacionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean // <--- CAMBIO DE ANOTACIÓN
    private CalificacionService service;

    @MockBean
    private JwtService jwtService;

    @MockBean
    private UserDetailsService userDetailsService;

    @Autowired
    private ObjectMapper objectMapper;

    private CalificacionDTO calificacionDTO;

    @BeforeEach
    void setUp() {
        objectMapper.registerModule(new JavaTimeModule());

        calificacionDTO = new CalificacionDTO();
        calificacionDTO.setIdCalificacion(1);
        calificacionDTO.setEstrellas(5);
    }

    @Test
    void testFindAll() throws Exception {
        when(service.findAll()).thenReturn(List.of(calificacionDTO));

        mockMvc.perform(get("/api/calificaciones"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].idCalificacion").value(1))
                .andExpect(jsonPath("$[0].estrellas").value(5));
    }

    @Test
    void testFindById_Found() throws Exception {
        when(service.findById(1)).thenReturn(Optional.of(calificacionDTO));

        mockMvc.perform(get("/api/calificaciones/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idCalificacion").value(1));
    }

    @Test
    void testFindById_NotFound() throws Exception {
        when(service.findById(99)).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/calificaciones/99"))
                .andExpect(status().isNotFound());
    }

    @Test
    void testCreate() throws Exception {
        when(service.save(any(CalificacionDTO.class))).thenReturn(calificacionDTO);

        mockMvc.perform(post("/api/calificaciones")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(calificacionDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.estrellas").value(5));
    }

    @Test
    void testUpdate_Success() throws Exception {
        when(service.update(eq(1), any(CalificacionDTO.class))).thenReturn(calificacionDTO);

        mockMvc.perform(put("/api/calificaciones/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(calificacionDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idCalificacion").value(1));
    }

    @Test
    void testUpdate_NotFound() throws Exception {
        when(service.update(eq(99), any(CalificacionDTO.class))).thenThrow(new RuntimeException("Not found"));

        mockMvc.perform(put("/api/calificaciones/99")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(calificacionDTO)))
                .andExpect(status().isNotFound());
    }

    @Test
    void testDelete() throws Exception {
        doNothing().when(service).deleteById(1);

        mockMvc.perform(delete("/api/calificaciones/1"))
                .andExpect(status().isNoContent());
    }

    @Test
    @DisplayName("GET /api/calificaciones/promedio-por-genero - Debe retornar 200 OK")
    void getPromedioPorGenero_Exitoso() throws Exception {
        // Nota: Asegúrate de adaptar el servicio de este endpoint de la misma manera
        // que los anteriores.
        mockMvc.perform(get("/api/calificaciones/promedio-por-genero")
                .param("genero", "Terror")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}