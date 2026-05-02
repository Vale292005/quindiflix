package com.quindiflix.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.quindiflix.dto.EpisodioDTO;
import com.quindiflix.service.EpisodioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean; // <-- CAMBIO: Importación para 3.3.0
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(EpisodioController.class)
class EpisodioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean // <-- CAMBIO: De @MockitoBean a @MockBean
    private EpisodioService service;

    @Autowired
    private ObjectMapper objectMapper;

    private EpisodioDTO episodioDTO;

    @BeforeEach
    void setUp() {
        episodioDTO = new EpisodioDTO();
        episodioDTO.setIdEpisodio(1);
        episodioDTO.setTitulo("El Comienzo");
        episodioDTO.setNumero(1);
    }

    @Test
    void testFindAll() throws Exception {
        when(service.findAll()).thenReturn(List.of(episodioDTO));

        mockMvc.perform(get("/api/episodios"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].idEpisodio").value(1))
                .andExpect(jsonPath("$[0].titulo").value("El Comienzo"))
                .andExpect(jsonPath("$[0].numero").value(1));
    }

    @Test
    void testFindById_Found() throws Exception {
        when(service.findById(1)).thenReturn(Optional.of(episodioDTO));

        mockMvc.perform(get("/api/episodios/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.titulo").value("El Comienzo"));
    }

    @Test
    void testFindById_NotFound() throws Exception {
        when(service.findById(99)).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/episodios/99"))
                .andExpect(status().isNotFound());
    }

    @Test
    void testCreate() throws Exception {
        when(service.save(any(EpisodioDTO.class))).thenReturn(episodioDTO);

        mockMvc.perform(post("/api/episodios")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(episodioDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idEpisodio").value(1));
    }

    @Test
    void testUpdate_Success() throws Exception {
        // Mock de búsqueda exitosa seguido de guardado
        when(service.findById(1)).thenReturn(Optional.of(episodioDTO));
        when(service.save(any(EpisodioDTO.class))).thenReturn(episodioDTO);

        mockMvc.perform(put("/api/episodios/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(episodioDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.titulo").value("El Comienzo"));
    }

    @Test
    void testUpdate_NotFound() throws Exception {
        when(service.findById(99)).thenReturn(Optional.empty());

        mockMvc.perform(put("/api/episodios/99")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(episodioDTO)))
                .andExpect(status().isNotFound());
    }

    @Test
    void testDelete() throws Exception {
        doNothing().when(service).deleteById(1);

        mockMvc.perform(delete("/api/episodios/1"))
                .andExpect(status().isNoContent());
    }
}