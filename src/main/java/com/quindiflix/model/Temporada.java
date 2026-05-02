package com.quindiflix.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
import lombok.ToString;

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

    @JsonIgnore
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "id_contenido")
    private Contenido contenido;
    
    @JsonIgnore
    @ToString.Exclude
    @OneToMany(mappedBy = "temporada")
    private List<Episodio> episodios;
}
