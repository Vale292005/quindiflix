package com.quindiflix.mapper;

import org.springframework.stereotype.Component;

import com.quindiflix.dto.CategoriaDTO;
import com.quindiflix.model.Categoria;

@Component
public class CategoriaMapper {

    public CategoriaDTO toDTO(Categoria entity) {
        if (entity == null) {
            return null;
        }
        CategoriaDTO dto = new CategoriaDTO();
        dto.setIdCategoria(entity.getIdCategoria());
        dto.setNombre(entity.getNombre());
        return dto;
    }

    public Categoria toEntity(CategoriaDTO dto) {
        if (dto == null) {
            return null;
        }
        Categoria entity = new Categoria();
        entity.setIdCategoria(dto.getIdCategoria());
        entity.setNombre(dto.getNombre());
        return entity;
    }
}
