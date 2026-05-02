package com.quindiflix.model;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Plan {
        @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPlan;

    private String nombrePlan;
    private BigDecimal precio;
    private String calidadVideo;
    private Integer cantidadPantallas;
    private Integer perfilesPermitidos;

    @OneToMany(mappedBy = "plan")
    private List<Cuenta> cuentas;
}
