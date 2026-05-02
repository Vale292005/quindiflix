package com.quindiflix.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.quindiflix.dto.EmpleadoDTO;
import com.quindiflix.service.EmpleadoService;
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

@WebMvcTest(EmpleadoController.class)
class EmpleadoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean // <-- CAMBIO: De @MockitoBean a @MockBean
    private EmpleadoService service;

    @Autowired
    private ObjectMapper objectMapper;

    private EmpleadoDTO empleadoDTO;

    @BeforeEach
    void setUp() {
        empleadoDTO = new EmpleadoDTO();
        empleadoDTO.setIdEmpleado(1);
        empleadoDTO.setNombreCompleto("Juan Perez");
        empleadoDTO.setCorreo("juan.perez@quindiflix.com");
        empleadoDTO.setCargo("Analista QA");
    }

    @Test
    void testFindAll() throws Exception {
        when(service.findAll()).thenReturn(List.of(empleadoDTO));

        mockMvc.perform(get("/api/empleados"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].idEmpleado").value(1))
                .andExpect(jsonPath("$[0].nombreCompleto").value("Juan Perez"))
                .andExpect(jsonPath("$[0].cargo").value("Analista QA"));
    }

    @Test
    void testFindById_Found() throws Exception {
        when(service.findById(1)).thenReturn(Optional.of(empleadoDTO));

        mockMvc.perform(get("/api/empleados/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombreCompleto").value("Juan Perez"));
    }

    @Test
    void testFindById_NotFound() throws Exception {
        when(service.findById(99)).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/empleados/99"))
                .andExpect(status().isNotFound());
    }

    @Test
    void testCreate() throws Exception {
        when(service.save(any(EmpleadoDTO.class))).thenReturn(empleadoDTO);

        mockMvc.perform(post("/api/empleados")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(empleadoDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idEmpleado").value(1))
                .andExpect(jsonPath("$.correo").value("juan.perez@quindiflix.com"));
    }

    @Test
    void testUpdate_Success() throws Exception {
        when(service.findById(1)).thenReturn(Optional.of(empleadoDTO));
        when(service.save(any(EmpleadoDTO.class))).thenReturn(empleadoDTO);

        mockMvc.perform(put("/api/empleados/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(empleadoDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombreCompleto").value("Juan Perez"));
    }

    @Test
    void testUpdate_NotFound() throws Exception {
        when(service.findById(99)).thenReturn(Optional.empty());

        mockMvc.perform(put("/api/empleados/99")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(empleadoDTO)))
                .andExpect(status().isNotFound());
    }

    @Test
    void testDelete() throws Exception {
        doNothing().when(service).deleteById(1);

        mockMvc.perform(delete("/api/empleados/1"))
                .andExpect(status().isNoContent());
    }
}