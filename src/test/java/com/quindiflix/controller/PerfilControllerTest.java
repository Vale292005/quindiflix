package com.quindiflix.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.quindiflix.model.Perfil;
import com.quindiflix.service.PerfilService;
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

@WebMvcTest(PerfilController.class)
class PerfilControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private PerfilService service;

    @Autowired
    private ObjectMapper objectMapper;

    private Perfil perfil;

    @BeforeEach
    void setUp() {
        perfil = Perfil.builder()
                .idPerfil(1)
                .nombre("Usuario Pro")
                .avatar("avatar_cool.png")
                .tipoPerfil("ADULTO")
                .build();
    }

    @Test
    void testFindAll() throws Exception {
        when(service.findAll()).thenReturn(List.of(perfil));

        mockMvc.perform(get("/api/perfiles"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].idPerfil").value(1))
                .andExpect(jsonPath("$[0].nombre").value("Usuario Pro"))
                .andExpect(jsonPath("$[0].tipoPerfil").value("ADULTO"));
    }

    @Test
    void testFindById_Found() throws Exception {
        when(service.findById(1)).thenReturn(Optional.of(perfil));

        mockMvc.perform(get("/api/perfiles/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre").value("Usuario Pro"));
    }

    @Test
    void testFindById_NotFound() throws Exception {
        when(service.findById(99)).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/perfiles/99"))
                .andExpect(status().isNotFound());
    }

    @Test
    void testCreate() throws Exception {
        when(service.save(any(Perfil.class))).thenReturn(perfil);

        mockMvc.perform(post("/api/perfiles")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(perfil)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idPerfil").value(1))
                .andExpect(jsonPath("$.nombre").value("Usuario Pro"));
    }

    @Test
    void testUpdate_Success() throws Exception {
        when(service.findById(1)).thenReturn(Optional.of(perfil));
        when(service.save(any(Perfil.class))).thenReturn(perfil);

        mockMvc.perform(put("/api/perfiles/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(perfil)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idPerfil").value(1));
    }

    @Test
    void testDelete() throws Exception {
        doNothing().when(service).deleteById(1);

        mockMvc.perform(delete("/api/perfiles/1"))
                .andExpect(status().isNoContent());
    }
}