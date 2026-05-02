package com.quindiflix.model;

import java.time.LocalDate;

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
public class Referido {
        @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReferido;

    @ManyToOne
    @JoinColumn(name = "id_usuario_referidor")
    private Usuario referidor;

    @ManyToOne
    @JoinColumn(name = "id_usuario_referido")
    private Usuario referido;

    private LocalDate fechaRegistro;
    private Boolean activo;
}
