package com.quindiflix.mapper;

import org.springframework.stereotype.Component;

import com.quindiflix.dto.PagoDTO;
import com.quindiflix.model.Pago;

@Component
public class PagoMapper {

    public PagoDTO toDTO(Pago entity) {
        if (entity == null) {
            return null;
        }
        PagoDTO dto = new PagoDTO();
        dto.setIdPago(entity.getIdPago());
        dto.setFechaPago(entity.getFechaPago());
        dto.setMonto(entity.getMonto());
        dto.setMetodoPago(entity.getMetodoPago());
        dto.setEstadoPago(entity.getEstadoPago());
        dto.setIdCuenta(entity.getCuenta() != null ? entity.getCuenta().getIdCuenta() : null);
        return dto;
    }

    public Pago toEntity(PagoDTO dto) {
        if (dto == null) {
            return null;
        }
        Pago entity = new Pago();
        entity.setIdPago(dto.getIdPago());
        entity.setMonto(dto.getMonto());
        entity.setFechaPago(dto.getFechaPago());
        entity.setMetodoPago(dto.getMetodoPago());
        entity.setEstadoPago(dto.getEstadoPago());
        return entity;
    }
}
