package com.quindiflix.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Temporada {
        @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTemporada;

    private Integer numeroTemporada;
    private String titulo;

    @ManyToOne
    @JoinColumn(name = "id_contenido")
    private Contenido contenido;

    @OneToMany(mappedBy = "temporada")
    private List<Episodio> episodios;
}
