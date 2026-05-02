package com.quindiflix.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToOne;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;

    private String nombreCompleto;
    private String correoElectronico;
    private String telefono;
    private LocalDate fechaNacimiento;
    private String ciudadResidencia;

    @JsonIgnore
    @ToString.Exclude
    @OneToOne(mappedBy = "usuario")
    private Cuenta cuenta;
    private String password; 
}