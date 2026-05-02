package com.quindiflix.mapper;

import org.springframework.stereotype.Component;

import com.quindiflix.dto.PlanDTO;
import com.quindiflix.model.Plan;

@Component
public class PlanMapper {

    public PlanDTO toDTO(Plan entity) {
        if (entity == null) {
            return null;
        }
        PlanDTO dto = new PlanDTO();
        dto.setIdPlan(entity.getIdPlan());
        dto.setNombrePlan(entity.getNombrePlan());
        dto.setPrecio(entity.getPrecio());
        dto.setCalidadVideo(entity.getCalidadVideo());
        dto.setCantidadPantallas(entity.getCantidadPantallas());
        dto.setPerfilesPermitidos(entity.getPerfilesPermitidos());
        return dto;
    }

    public Plan toEntity(PlanDTO dto) {
        if (dto == null) {
            return null;
        }
        Plan entity = new Plan();
        entity.setIdPlan(dto.getIdPlan());
        entity.setNombrePlan(dto.getNombrePlan());
        entity.setPrecio(dto.getPrecio());
        entity.setCalidadVideo(dto.getCalidadVideo());
        entity.setCantidadPantallas(dto.getCantidadPantallas());
        entity.setPerfilesPermitidos(dto.getPerfilesPermitidos());
        return entity;
    }
}
