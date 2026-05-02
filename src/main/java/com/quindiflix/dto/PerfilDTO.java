package com.quindiflix.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PerfilDTO {
    private Integer idPerfil;
    private String nombre;
    private String avatar;
    private String tipoPerfil;
    private Integer idCuenta;
}
