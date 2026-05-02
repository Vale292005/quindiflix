package com.quindiflix.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.quindiflix.dto.UsuarioDTO;
import com.quindiflix.service.UsuarioService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UsuarioController.class)
public class UsuarioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UsuarioService service;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testFindAll() throws Exception {
        UsuarioDTO dto1 = new UsuarioDTO(1, "Juan Pérez", "juan@email.com", "123456789", LocalDate.now());
        UsuarioDTO dto2 = new UsuarioDTO(2, "María García", "maria@email.com", "987654321", LocalDate.now());

        when(service.findAll()).thenReturn(Arrays.asList(dto1, dto2));

        mockMvc.perform(get("/api/usuarios"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()").value(2));
    }

    @Test
    public void testFindById() throws Exception {
        UsuarioDTO dto = new UsuarioDTO(1, "Juan Pérez", "juan@email.com", "123456789", LocalDate.now());

        when(service.findById(1)).thenReturn(Optional.of(dto));

        mockMvc.perform(get("/api/usuarios/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.idUsuario").value(1));
    }

    @Test
    public void testFindByIdNotFound() throws Exception {
        when(service.findById(1)).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/usuarios/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testCreate() throws Exception {
        UsuarioDTO dto = new UsuarioDTO(null, "Nuevo Usuario", "nuevo@email.com", "111111111", LocalDate.now());
        UsuarioDTO savedDto = new UsuarioDTO(1, "Nuevo Usuario", "nuevo@email.com", "111111111", LocalDate.now());

        when(service.save(any())).thenReturn(savedDto);

        mockMvc.perform(post("/api/usuarios")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idUsuario").value(1));
    }

    @Test
    public void testUpdate() throws Exception {
        UsuarioDTO dto = new UsuarioDTO(1, "Usuario Actualizado", "actualizado@email.com", "222222222", LocalDate.now());

        when(service.findById(1)).thenReturn(Optional.of(dto));
        when(service.save(any())).thenReturn(dto);

        mockMvc.perform(put("/api/usuarios/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombreCompleto").value("Usuario Actualizado"));
    }

    @Test
    public void testUpdateNotFound() throws Exception {
        UsuarioDTO dto = new UsuarioDTO(1, "Usuario", "email@email.com", "123456789", LocalDate.now());

        when(service.findById(1)).thenReturn(Optional.empty());

        mockMvc.perform(put("/api/usuarios/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testDelete() throws Exception {
        doNothing().when(service).deleteById(1);

        mockMvc.perform(delete("/api/usuarios/1"))
                .andExpect(status().isNoContent());

        verify(service, times(1)).deleteById(1);
    }
}
