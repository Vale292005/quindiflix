package com.quindiflix.mapper;

import org.springframework.stereotype.Component;

import com.quindiflix.dto.CuentaDTO;
import com.quindiflix.model.Cuenta;

@Component
public class CuentaMapper {

    public CuentaDTO toDTO(Cuenta entity) {
        if (entity == null) {
            return null;
        }
        CuentaDTO dto = new CuentaDTO();
        dto.setIdCuenta(entity.getIdCuenta());
        dto.setEstadoServicio(entity.getEstadoServicio());
        dto.setFechaUltimoPago(entity.getFechaUltimoPago());
        dto.setIdUsuario(entity.getUsuario() != null ? entity.getUsuario().getIdUsuario() : null);
        dto.setIdPlan(entity.getPlan() != null ? entity.getPlan().getIdPlan() : null);
        return dto;
    }

    public Cuenta toEntity(CuentaDTO dto) {
        if (dto == null) {
            return null;
        }
        Cuenta entity = new Cuenta();
        entity.setIdCuenta(dto.getIdCuenta());
        entity.setEstadoServicio(dto.getEstadoServicio());
        entity.setFechaUltimoPago(dto.getFechaUltimoPago());
        return entity;
    }
}
