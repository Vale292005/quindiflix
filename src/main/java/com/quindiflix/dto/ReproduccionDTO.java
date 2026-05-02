package com.quindiflix.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReproduccionDTO {
    private Integer idReproduccion;
    private LocalDateTime fechaHoraInicio;
    private LocalDateTime fechaHoraFin;
    private String dispositivo;
    private BigDecimal porcentajeAvance;
    private Integer idPerfil;
    private Integer idContenido;
    private Integer idEpisodio;

}
