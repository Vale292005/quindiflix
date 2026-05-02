package com.quindiflix.mapper;

import org.springframework.stereotype.Component;

import com.quindiflix.dto.TemporadaDTO;
import com.quindiflix.model.Contenido;
import com.quindiflix.model.Temporada;

@Component
public class TemporadaMapper {

    public TemporadaDTO toDTO(Temporada entity) {
        if (entity == null) {
            return null;
        }
        TemporadaDTO dto = new TemporadaDTO();
        dto.setIdTemporada(entity.getIdTemporada());
        dto.setNumeroTemporada(entity.getNumeroTemporada());
        dto.setTitulo(entity.getTitulo());
        dto.setIdContenido(entity.getContenido() != null ? entity.getContenido().getIdContenido() : null);
        return dto;
    }

    public Temporada toEntity(TemporadaDTO dto) {
        if (dto == null) {
            return null;
        }
        Temporada entity = new Temporada();
        entity.setIdTemporada(dto.getIdTemporada());
        entity.setNumeroTemporada(dto.getNumeroTemporada());
        entity.setTitulo(dto.getTitulo());
        entity.setContenido(dto.getIdContenido() != null ? Contenido.builder().idContenido(dto.getIdContenido()).build() : null);
        return entity;
    }
}
