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
public class CalificacionDTO {
    private Integer idCalificacion;
    private Integer idPerfil;
    private Integer idContenido;
    private Integer estrellas;
    private LocalDateTime fecha;

}
