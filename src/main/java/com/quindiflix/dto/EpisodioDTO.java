package com.quindiflix.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EpisodioDTO {
    private Integer idEpisodio;
    private String titulo;
    private Integer numero;
    private Integer idTemporada;

}
