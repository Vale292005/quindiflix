package com.quindiflix.mapper;

import org.springframework.stereotype.Component;

import com.quindiflix.dto.EmpleadoDTO;
import com.quindiflix.model.Empleado;

@Component
public class EmpleadoMapper {

    public EmpleadoDTO toDTO(Empleado entity) {
        if (entity == null) {
            return null;
        }
        EmpleadoDTO dto = new EmpleadoDTO();
        dto.setIdEmpleado(entity.getIdEmpleado());
        dto.setNombreCompleto(entity.getNombreCompleto());
        dto.setCorreo(entity.getCorreo());
        dto.setTelefono(entity.getTelefono());
        dto.setCargo(entity.getCargo());
        dto.setIdDepartamento(entity.getDepartamento()!=null ? entity.getDepartamento().getIdDepartamento() : null);
        return dto;
    }

    public Empleado toEntity(EmpleadoDTO dto) {
        if (dto == null) {
            return null;
        }
        Empleado entity = new Empleado();
        entity.setIdEmpleado(dto.getIdEmpleado());
        entity.setNombreCompleto(dto.getNombreCompleto());
        entity.setCorreo(dto.getCorreo());
        entity.setTelefono(dto.getTelefono());
        entity.setCargo(dto.getCargo());
        return entity;
    }
}
