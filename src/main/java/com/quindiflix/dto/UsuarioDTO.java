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
public class UsuarioDTO {
        private Integer idUsuario;
    private String nombreCompleto;
    private String correoElectronico;
    private String telefono;
    private LocalDate fechaNacimiento;
    private String ciudadResidencia;
}
