package com.quindiflix.mapper;

import org.springframework.stereotype.Component;

import com.quindiflix.dto.GeneroDTO;
import com.quindiflix.model.Genero;

@Component
public class GeneroMapper {

    public GeneroDTO toDTO(Genero entity) {
        if (entity == null) {
            return null;
        }
        GeneroDTO dto = new GeneroDTO();
        dto.setIdGenero(entity.getIdGenero());
        dto.setNombre(entity.getNombre());
        return dto;
    }

    public Genero toEntity(GeneroDTO dto) {
        if (dto == null) {
            return null;
        }
        Genero entity = new Genero();
        entity.setIdGenero(dto.getIdGenero());
        entity.setNombre(dto.getNombre());
        return entity;
    }
}
