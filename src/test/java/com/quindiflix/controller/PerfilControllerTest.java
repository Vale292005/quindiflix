package com.quindiflix.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.quindiflix.dto.PerfilDTO;
import com.quindiflix.exception.BadRequestException;
import com.quindiflix.service.PerfilService;
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
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PerfilController.class)
class PerfilControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean // <-- CAMBIO: De @MockitoBean a @MockBean
    private PerfilService service;

    @Autowired
    private ObjectMapper objectMapper;

    private PerfilDTO perfilDTO;

    @BeforeEach
    void setUp() {
        perfilDTO = new PerfilDTO();
        perfilDTO.setIdPerfil(1);
        perfilDTO.setNombre("Kid Mode");
        perfilDTO.setAvatar("batman_icon.png");
        perfilDTO.setTipoPerfil("INFANTIL");
    }

    @Test
    void testFindAll() throws Exception {
        when(service.findAll()).thenReturn(List.of(perfilDTO));

        mockMvc.perform(get("/api/perfiles"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].idPerfil").value(1))
                .andExpect(jsonPath("$[0].nombre").value("Kid Mode"));
    }

    @Test
    void testFindById_Found() throws Exception {
        when(service.findById(1)).thenReturn(Optional.of(perfilDTO));

        mockMvc.perform(get("/api/perfiles/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre").value("Kid Mode"));
    }

    @Test
    void testFindById_NotFound() throws Exception {
        when(service.findById(99)).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/perfiles/99"))
                .andExpect(status().isNotFound());
    }

    @Test
    void testCreate_Success() throws Exception {
        when(service.save(any(PerfilDTO.class))).thenReturn(perfilDTO);

        mockMvc.perform(post("/api/perfiles")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(perfilDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.avatar").value("batman_icon.png"));
    }

    @Test
    void testCreate_BadRequest_LimiteAlcanzado() throws Exception {
        when(service.save(any(PerfilDTO.class)))
                .thenThrow(new BadRequestException("Límite de perfiles alcanzado"));

        mockMvc.perform(post("/api/perfiles")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(perfilDTO)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testUpdate_Success() throws Exception {
        when(service.update(eq(1), any(PerfilDTO.class))).thenReturn(perfilDTO);

        mockMvc.perform(put("/api/perfiles/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(perfilDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idPerfil").value(1));
    }

    @Test
    void testUpdate_NotFound() throws Exception {
        when(service.update(eq(99), any(PerfilDTO.class)))
                .thenThrow(new RuntimeException("Perfil no encontrado"));

        mockMvc.perform(put("/api/perfiles/99")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(perfilDTO)))
                .andExpect(status().isNotFound());
    }

    @Test
    void testUpdate_BadRequest() throws Exception {
        when(service.update(eq(1), any(PerfilDTO.class)))
                .thenThrow(new BadRequestException("Datos inválidos"));

        mockMvc.perform(put("/api/perfiles/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(perfilDTO)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testDelete() throws Exception {
        doNothing().when(service).deleteById(1);

        mockMvc.perform(delete("/api/perfiles/1"))
                .andExpect(status().isNoContent());
    }
}