package com.quindiflix.mapper;

import org.springframework.stereotype.Component;

import com.quindiflix.dto.ReproduccionDTO;
import com.quindiflix.model.Reproduccion;

@Component
public class ReproduccionMapper {

    public ReproduccionDTO toDTO(Reproduccion entity) {
        if (entity == null) {
            return null;
        }
        ReproduccionDTO dto = new ReproduccionDTO();
        dto.setIdReproduccion(entity.getIdReproduccion());
        dto.setFechaHoraInicio(entity.getFechaHoraInicio());
        dto.setFechaHoraFin(entity.getFechaHoraFin());
        dto.setDispositivo(entity.getDispositivo());
        dto.setPorcentajeAvance(entity.getPorcentajeAvance());
        dto.setIdPerfil(entity.getPerfil()!=null?entity.getPerfil().getIdPerfil():null);
        dto.setIdContenido(entity.getContenido()!=null?entity.getContenido().getIdContenido():null);
        dto.setIdEpisodio(entity.getEpisodio()!=null?entity.getEpisodio().getIdEpisodio():null);
        return dto;
    }

    public Reproduccion toEntity(ReproduccionDTO dto) {
        if (dto == null) {
            return null;
        }
        Reproduccion entity = new Reproduccion();
        entity.setIdReproduccion(dto.getIdReproduccion());
        entity.setFechaHoraInicio(dto.getFechaHoraInicio());
        entity.setFechaHoraFin(dto.getFechaHoraFin());
        entity.setDispositivo(dto.getDispositivo());
        entity.setPorcentajeAvance(dto.getPorcentajeAvance());
        return entity;
    }
}
