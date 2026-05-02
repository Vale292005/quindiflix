package com.quindiflix.mapper;

import org.springframework.stereotype.Component;

import com.quindiflix.dto.DepartamentoDTO;
import com.quindiflix.model.Departamento;

@Component
public class DepartamentoMapper {

    public DepartamentoDTO toDTO(Departamento entity) {
        if (entity == null) {
            return null;
        }
        DepartamentoDTO dto = new DepartamentoDTO();
        dto.setIdDepartamento(entity.getIdDepartamento());
        dto.setNombre(entity.getNombre());
        return dto;
    }

    public Departamento toEntity(DepartamentoDTO dto) {
        if (dto == null) {
            return null;
        }
        Departamento entity = new Departamento();
        entity.setIdDepartamento(dto.getIdDepartamento());
        entity.setNombre(dto.getNombre());
        return entity;
    }
}
