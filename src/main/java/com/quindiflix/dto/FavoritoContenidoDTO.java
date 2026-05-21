package com.quindiflix.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FavoritoContenidoDTO {
    private Integer idContenido;
    private String titulo;
    private String tipoContenido;
    private Boolean esOriginal;
    private String urlImagen;
}
