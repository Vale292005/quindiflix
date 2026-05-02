package com.quindiflix.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.quindiflix.dto.DepartamentoDTO;
import com.quindiflix.mapper.DepartamentoMapper;
import com.quindiflix.model.Departamento;
import com.quindiflix.service.DepartamentoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DepartamentoController.class)
class DepartamentoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private DepartamentoService service;

    @MockitoBean
    private DepartamentoMapper mapper;

    @Autowired
    private ObjectMapper objectMapper;

    private Departamento departamento;
    private DepartamentoDTO departamentoDTO;

    @BeforeEach
    void setUp() {
        // Entidad simulada para la respuesta del Service
        departamento = Departamento.builder()
                .idDepartamento(1)
                .nombre("Recursos Humanos")
                .empleados(new ArrayList<>())
                .build();

        // DTO simulado para la respuesta del Mapper
        departamentoDTO = new DepartamentoDTO();
        departamentoDTO.setIdDepartamento(1);
        departamentoDTO.setNombre("Recursos Humanos");
    }

    @Test
    void testFindAll() throws Exception {
        when(service.findAll()).thenReturn(List.of(departamento));
        when(mapper.toDTO(any(Departamento.class))).thenReturn(departamentoDTO);

        mockMvc.perform(get("/api/departamentos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].idDepartamento").value(1))
                .andExpect(jsonPath("$[0].nombre").value("Recursos Humanos"));
    }

    @Test
    void testFindById_Found() throws Exception {
        when(service.findById(1)).thenReturn(Optional.of(departamento));
        when(mapper.toDTO(departamento)).thenReturn(departamentoDTO);

        mockMvc.perform(get("/api/departamentos/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre").value("Recursos Humanos"));
    }

    @Test
    void testFindById_NotFound() throws Exception {
        when(service.findById(99)).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/departamentos/99"))
                .andExpect(status().isNotFound());
    }

    @Test
    void testCreate() throws Exception {
        when(mapper.toEntity(any(DepartamentoDTO.class))).thenReturn(departamento);
        when(service.save(any(Departamento.class))).thenReturn(departamento);
        when(mapper.toDTO(any(Departamento.class))).thenReturn(departamentoDTO);

        mockMvc.perform(post("/api/departamentos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(departamentoDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre").value("Recursos Humanos"));
    }

    @Test
    void testUpdate_Success() throws Exception {
        when(service.findById(1)).thenReturn(Optional.of(departamento));
        when(mapper.toEntity(any(DepartamentoDTO.class))).thenReturn(departamento);
        when(service.save(any(Departamento.class))).thenReturn(departamento);
        when(mapper.toDTO(any(Departamento.class))).thenReturn(departamentoDTO);

        mockMvc.perform(put("/api/departamentos/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(departamentoDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idDepartamento").value(1));
    }

    @Test
    void testDelete() throws Exception {
        doNothing().when(service).deleteById(1);

        mockMvc.perform(delete("/api/departamentos/1"))
                .andExpect(status().isNoContent());
    }
}