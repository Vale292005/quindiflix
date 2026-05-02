package com.quindiflix.mapper;

import org.springframework.stereotype.Component;

import com.quindiflix.dto.FavoritoDTO;
import com.quindiflix.model.Favorito;

@Component
public class FavoritoMapper {

    public FavoritoDTO toDTO(Favorito entity) {
        if (entity == null) {
            return null;
        }
        FavoritoDTO dto = new FavoritoDTO();
        dto.setIdFavorito(entity.getIdFavorito());
        dto.setFecha(entity.getFecha());
        return dto;
    }

    public Favorito toEntity(FavoritoDTO dto) {
        if (dto == null) {
            return null;
        }
        Favorito entity = new Favorito();
        entity.setIdFavorito(dto.getIdFavorito());
        entity.setFecha(dto.getFecha());
        return entity;
    }
}
