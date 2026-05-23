package com.quindiflix.model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
public class Contenido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idContenido;

    private String titulo;
    private LocalDate fechaIncorporacion;
    private String tipoContenido;
    private Boolean esOriginal;

    @JsonIgnore
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "id_empleado")
    private Empleado empleado;

    @JsonIgnore
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    @JsonIgnore
    @ToString.Exclude
    @OneToMany(mappedBy = "contenido")
    private List<Temporada> temporadas;

    @JsonIgnore
    @ToString.Exclude
    @ManyToMany
    @JoinTable(name = "contenido_genero", joinColumns = @JoinColumn(name = "id_contenido"), inverseJoinColumns = @JoinColumn(name = "id_genero"))
    private List<Genero> generos;
    private String urlImagen;
}
