package com.quindiflix.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlanDTO {
    private Integer idPlan;
    private String nombrePlan;
    private BigDecimal precio;
    private String calidadVideo;
    private Integer cantidadPantallas;
    private Integer perfilesPermitidos;

}
