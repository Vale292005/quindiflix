package com.quindiflix.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TemporadaDTO {
    private Integer idTemporada;
    private Integer numeroTemporada;
    private String titulo;
    private Integer idContenido;

}
