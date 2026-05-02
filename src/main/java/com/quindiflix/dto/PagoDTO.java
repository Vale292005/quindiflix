package com.quindiflix.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PagoDTO {
    private Integer idPago;
    private LocalDate fechaPago;
    private BigDecimal monto;
    private String metodoPago;
    private String estadoPago;
    private Integer idCuenta;

}
