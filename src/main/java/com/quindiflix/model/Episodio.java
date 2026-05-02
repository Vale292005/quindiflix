package com.quindiflix.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Episodio {
        @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEpisodio;

    private String titulo;
    private Integer numero;

    @ManyToOne
    @JoinColumn(name = "id_temporada")
    private Temporada temporada;
}
