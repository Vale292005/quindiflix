package com.quindiflix.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FavoritoDTO {
    private Integer idFavorito;
    private Integer idPerfil;
    private Integer idContenido;
    private LocalDateTime fecha;

}
