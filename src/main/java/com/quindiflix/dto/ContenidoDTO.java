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
public class ContenidoDTO {
    private Integer idContenido;
    private String titulo;
    private LocalDate fechaIncorporacion;
    private String tipoContenido;
    private Boolean esOriginal;
    private Integer idEmpleadoResponsable;
    private Integer idCategoria;
    private String urlImagen;

}
