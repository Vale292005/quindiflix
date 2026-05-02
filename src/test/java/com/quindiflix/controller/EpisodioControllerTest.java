package com.quindiflix.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.quindiflix.dto.EpisodioDTO;
import com.quindiflix.mapper.EpisodioMapper;
import com.quindiflix.model.Episodio;
import com.quindiflix.service.EpisodioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
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

    @MockitoBean
    private EpisodioService service;

    @MockitoBean
    private EpisodioMapper mapper;

    @Autowired
    private ObjectMapper objectMapper;

    private Episodio episodio;
    private EpisodioDTO episodioDTO;

    @BeforeEach
    void setUp() {
        // Entidad simulada
        episodio = Episodio.builder()
                .idEpisodio(1)
                .titulo("Piloto")
                .numero(1)
                .build();

        // DTO simulado
        episodioDTO = new EpisodioDTO();
        episodioDTO.setIdEpisodio(1);
        episodioDTO.setTitulo("Piloto");
        episodioDTO.setNumero(1);
    }

    @Test
    void testFindAll() throws Exception {
        when(service.findAll()).thenReturn(List.of(episodio));
        when(mapper.toDTO(any(Episodio.class))).thenReturn(episodioDTO);

        mockMvc.perform(get("/api/episodios"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].idEpisodio").value(1))
                .andExpect(jsonPath("$[0].titulo").value("Piloto"))
                .andExpect(jsonPath("$[0].numero").value(1));
    }

    @Test
    void testFindById_Found() throws Exception {
        when(service.findById(1)).thenReturn(Optional.of(episodio));
        when(mapper.toDTO(episodio)).thenReturn(episodioDTO);

        mockMvc.perform(get("/api/episodios/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.titulo").value("Piloto"));
    }

    @Test
    void testFindById_NotFound() throws Exception {
        when(service.findById(99)).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/episodios/99"))
                .andExpect(status().isNotFound());
    }

    @Test
    void testCreate() throws Exception {
        when(mapper.toEntity(any(EpisodioDTO.class))).thenReturn(episodio);
        when(service.save(any(Episodio.class))).thenReturn(episodio);
        when(mapper.toDTO(any(Episodio.class))).thenReturn(episodioDTO);

        mockMvc.perform(post("/api/episodios")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(episodioDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.titulo").value("Piloto"));
    }

    @Test
    void testUpdate_Success() throws Exception {
        when(service.findById(1)).thenReturn(Optional.of(episodio));
        when(mapper.toEntity(any(EpisodioDTO.class))).thenReturn(episodio);
        when(service.save(any(Episodio.class))).thenReturn(episodio);
        when(mapper.toDTO(any(Episodio.class))).thenReturn(episodioDTO);

        mockMvc.perform(put("/api/episodios/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(episodioDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idEpisodio").value(1));
    }

    @Test
    void testDelete() throws Exception {
        doNothing().when(service).deleteById(1);

        mockMvc.perform(delete("/api/episodios/1"))
                .andExpect(status().isNoContent());
    }
}