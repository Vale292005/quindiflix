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
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEmpleado;

    private String nombreCompleto;
    private String correo;
    private String telefono;
    private String cargo;

    @JsonIgnore
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "id_departamento")
    private Departamento departamento;

    @JsonIgnore
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "id_supervisor")
    private Empleado supervisor;

    @JsonIgnore
    @ToString.Exclude
    @OneToMany(mappedBy = "supervisor")
    private List<Empleado> subordinados;
}
