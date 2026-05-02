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

public class ReferidoDTO {
    private Integer idReferido;
    private Integer idUsuarioReferidor;
    private Integer idUsuarioReferido;
    private LocalDate fechaRegistro;
    private Boolean activo;

}
