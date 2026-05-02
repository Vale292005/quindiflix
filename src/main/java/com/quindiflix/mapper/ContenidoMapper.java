package com.quindiflix.mapper;

import org.springframework.stereotype.Component;

import com.quindiflix.dto.ContenidoDTO;
import com.quindiflix.model.Contenido;

@Component
public class ContenidoMapper {

    public ContenidoDTO toDTO(Contenido entity) {
        if (entity == null) {
            return null;
        }
        ContenidoDTO dto = new ContenidoDTO();
        dto.setIdContenido(entity.getIdContenido());
        dto.setTitulo(entity.getTitulo());
        dto.setFechaIncorporacion(entity.getFechaIncorporacion());
        dto.setTipoContenido(entity.getTipoContenido());
        dto.setEsOriginal(entity.getEsOriginal());
        dto.setIdEmpleadoResponsable(entity.getEmpleado() != null ? entity.getEmpleado().getIdEmpleado() : null);
        dto.setIdCategoria(entity.getCategoria() != null ? entity.getCategoria().getIdCategoria() : null);
        return dto;
    }

    public Contenido toEntity(ContenidoDTO dto) {
        if (dto == null) {
            return null;
        }
        Contenido entity = new Contenido();
        entity.setIdContenido(dto.getIdContenido());
        entity.setTitulo(dto.getTitulo());
        entity.setFechaIncorporacion(dto.getFechaIncorporacion());
        entity.setTipoContenido(dto.getTipoContenido());
        entity.setEsOriginal(dto.getEsOriginal());
        // Las referencias a empleado y categoria se deben resolver en el servicio o controlador
        return entity;
    }
}
