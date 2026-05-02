package com.quindiflix.mapper;

import org.springframework.stereotype.Component;

import com.quindiflix.dto.CalificacionDTO;
import com.quindiflix.model.Calificacion;
@Component
public class CalificacionMapper {

    public CalificacionDTO toDTO(Calificacion entity) {
        if (entity == null) {
            return null;
        }
        CalificacionDTO dto = new CalificacionDTO();
        dto.setIdCalificacion(entity.getIdCalificacion());
        dto.setIdPerfil(entity.getPerfil() != null ? entity.getPerfil().getIdPerfil() : null);
        dto.setIdContenido(entity.getContenido() != null ? entity.getContenido().getIdContenido() : null);
        dto.setEstrellas(entity.getEstrellas());
        dto.setFecha(entity.getFecha());
        return dto;
    }

    public Calificacion toEntity(CalificacionDTO dto) {
        if (dto == null) {
            return null;
        }
        Calificacion entity = new Calificacion();
        entity.setIdCalificacion(dto.getIdCalificacion());
        // Note: For relationships, we need to fetch the entities separately or use IDs
        // For now, we'll set the IDs and assume the service handles the relationships
        entity.setEstrellas(dto.getEstrellas());
        entity.setFecha(dto.getFecha());
        return entity;
    }
}
