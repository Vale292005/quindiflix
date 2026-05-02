package com.quindiflix.mapper;

import org.springframework.stereotype.Component;

import com.quindiflix.dto.PerfilDTO;
import com.quindiflix.model.Perfil;

@Component
public class PerfilMapper {

    public PerfilDTO toDTO(Perfil entity) {
        if (entity == null) {
            return null;
        }
        PerfilDTO dto = new PerfilDTO();
        dto.setIdPerfil(entity.getIdPerfil());
        dto.setNombre(entity.getNombre());
        dto.setAvatar(entity.getAvatar());
        dto.setTipoPerfil(entity.getTipoPerfil());
        dto.setIdCuenta(entity.getCuenta() != null ? entity.getCuenta().getIdCuenta() : null);
        return dto;
    }

    public Perfil toEntity(PerfilDTO dto) {
        if (dto == null) {
            return null;
        }
        Perfil entity = new Perfil();
        entity.setIdPerfil(dto.getIdPerfil());
        entity.setNombre(dto.getNombre());
        entity.setAvatar(dto.getAvatar());
        entity.setTipoPerfil(dto.getTipoPerfil());
        return entity;
    }
}
