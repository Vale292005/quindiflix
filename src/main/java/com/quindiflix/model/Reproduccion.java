package com.quindiflix.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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
public class Reproduccion {
        @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReproduccion;

    private LocalDateTime fechaHoraInicio;
    private LocalDateTime fechaHoraFin;
    private String dispositivo;
    private BigDecimal porcentajeAvance;

    @ManyToOne
    @JoinColumn(name = "id_perfil")
    private Perfil perfil;

    @ManyToOne
    @JoinColumn(name = "id_contenido")
    private Contenido contenido;

    @ManyToOne
    @JoinColumn(name = "id_episodio")
    private Episodio episodio;
}
