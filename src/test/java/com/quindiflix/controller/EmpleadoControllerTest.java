package com.quindiflix.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.quindiflix.dto.EmpleadoDTO;
import com.quindiflix.mapper.EmpleadoMapper;
import com.quindiflix.model.Empleado;
import com.quindiflix.service.EmpleadoService;
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

@WebMvcTest(EmpleadoController.class)
class EmpleadoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private EmpleadoService service;

    @MockitoBean
    private EmpleadoMapper mapper;

    @Autowired
    private ObjectMapper objectMapper;

    private Empleado empleado;
    private EmpleadoDTO empleadoDTO;

    @BeforeEach
    void setUp() {
        // Entidad simulada
        empleado = Empleado.builder()
                .idEmpleado(1)
                .nombreCompleto("Pepito Pérez")
                .correo("pepito@quindiflix.com")
                .cargo("Desarrollador")
                .build();

        // DTO simulado
        empleadoDTO = new EmpleadoDTO();
        empleadoDTO.setIdEmpleado(1);
        empleadoDTO.setNombreCompleto("Pepito Pérez");
        empleadoDTO.setCorreo("pepito@quindiflix.com");
        empleadoDTO.setCargo("Desarrollador");
    }

    @Test
    void testFindAll() throws Exception {
        when(service.findAll()).thenReturn(List.of(empleado));
        when(mapper.toDTO(any(Empleado.class))).thenReturn(empleadoDTO);

        mockMvc.perform(get("/api/empleados"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nombreCompleto").value("Pepito Pérez"))
                .andExpect(jsonPath("$[0].cargo").value("Desarrollador"));
    }

    @Test
    void testFindById_Success() throws Exception {
        when(service.findById(1)).thenReturn(Optional.of(empleado));
        when(mapper.toDTO(empleado)).thenReturn(empleadoDTO);

        mockMvc.perform(get("/api/empleados/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idEmpleado").value(1))
                .andExpect(jsonPath("$.nombreCompleto").value("Pepito Pérez"));
    }

    @Test
    void testFindById_NotFound() throws Exception {
        when(service.findById(99)).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/empleados/99"))
                .andExpect(status().isNotFound());
    }

    @Test
    void testCreate() throws Exception {
        when(mapper.toEntity(any(EmpleadoDTO.class))).thenReturn(empleado);
        when(service.save(any(Empleado.class))).thenReturn(empleado);
        when(mapper.toDTO(any(Empleado.class))).thenReturn(empleadoDTO);

        mockMvc.perform(post("/api/empleados")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(empleadoDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombreCompleto").value("Pepito Pérez"));
    }

    @Test
    void testUpdate_Success() throws Exception {
        when(service.findById(1)).thenReturn(Optional.of(empleado));
        when(mapper.toEntity(any(EmpleadoDTO.class))).thenReturn(empleado);
        when(service.save(any(Empleado.class))).thenReturn(empleado);
        when(mapper.toDTO(any(Empleado.class))).thenReturn(empleadoDTO);

        mockMvc.perform(put("/api/empleados/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(empleadoDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idEmpleado").value(1));
    }

    @Test
    void testDelete() throws Exception {
        doNothing().when(service).deleteById(1);

        mockMvc.perform(delete("/api/empleados/1"))
                .andExpect(status().isNoContent());
    }
}