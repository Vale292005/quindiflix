package com.quindiflix.mapper;

import org.springframework.stereotype.Component;

import com.quindiflix.dto.UsuarioDTO;
import com.quindiflix.model.Usuario;

@Component
public class UsuarioMapper {

    public UsuarioDTO toDTO(Usuario entity) {
        if (entity == null) {
            return null;
        }
        UsuarioDTO dto = new UsuarioDTO();
        dto.setIdUsuario(entity.getIdUsuario());
        dto.setNombreCompleto(entity.getNombreCompleto());
        dto.setCorreoElectronico(entity.getCorreoElectronico());
        dto.setTelefono(entity.getTelefono());
        dto.setFechaNacimiento(entity.getFechaNacimiento());
        dto.setCiudadResidencia(entity.getCiudadResidencia());
        return dto;
    }

    public Usuario toEntity(UsuarioDTO dto) {
        if (dto == null) {
            return null;
        }
        Usuario entity = new Usuario();
        entity.setIdUsuario(dto.getIdUsuario());
        entity.setNombreCompleto(dto.getNombreCompleto());
        entity.setCorreoElectronico(dto.getCorreoElectronico());
        entity.setTelefono(dto.getTelefono());
        entity.setFechaNacimiento(dto.getFechaNacimiento());
        entity.setCiudadResidencia(dto.getCiudadResidencia());
        return entity;
    }
}
