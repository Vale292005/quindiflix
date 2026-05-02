package com.quindiflix.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CuentaDTO {
    private Integer idCuenta;
    private String estadoServicio;
    private LocalDate fechaUltimoPago;
    private Integer idUsuario;
    private Integer idPlan;

}
