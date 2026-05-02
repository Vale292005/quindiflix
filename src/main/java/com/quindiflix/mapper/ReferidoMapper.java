package com.quindiflix.mapper;

import org.springframework.stereotype.Component;

import com.quindiflix.dto.ReferidoDTO;
import com.quindiflix.model.Referido;

@Component
public class ReferidoMapper {

    public ReferidoDTO toDTO(Referido entity) {
        if (entity == null) {
            return null;
        }
        ReferidoDTO dto = new ReferidoDTO();
        dto.setIdReferido(entity.getIdReferido());
        dto.setFechaRegistro(entity.getFechaRegistro());
        dto.setActivo(entity.getActivo());
        dto.setIdUsuarioReferido(entity.getReferido()!=null?entity.getReferido().getIdUsuario():null);
        dto.setIdUsuarioReferidor(entity.getReferidor()!=null?entity.getReferidor().getIdUsuario():null);
        return dto;
    }

    public Referido toEntity(ReferidoDTO dto) {
        if (dto == null) {
            return null;
        }
        Referido entity = new Referido();
        entity.setIdReferido(dto.getIdReferido());
        entity.setFechaRegistro(dto.getFechaRegistro());
        entity.setActivo(dto.getActivo());
        return entity;
    }
}
