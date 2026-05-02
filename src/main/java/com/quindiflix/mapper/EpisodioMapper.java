package com.quindiflix.mapper;

import org.springframework.stereotype.Component;

import com.quindiflix.dto.EpisodioDTO;
import com.quindiflix.model.Episodio;

@Component
public class EpisodioMapper {

    public EpisodioDTO toDTO(Episodio entity) {
        if (entity == null) {
            return null;
        }
        EpisodioDTO dto = new EpisodioDTO();
        dto.setIdEpisodio(entity.getIdEpisodio());
        dto.setTitulo(entity.getTitulo());
        dto.setNumero(entity.getNumero());
        dto.setIdTemporada(entity.getTemporada()!=null?entity.getTemporada().getIdTemporada(): null);
        return dto;
    }

    public Episodio toEntity(EpisodioDTO dto) {
        if (dto == null) {
            return null;
        }
        Episodio entity = new Episodio();
        entity.setIdEpisodio(dto.getIdEpisodio());
        entity.setNumero(dto.getNumero());
        entity.setTitulo(dto.getTitulo());
        return entity;
    }
}
