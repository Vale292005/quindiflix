package com.quindiflix.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmpleadoDTO {
    private Integer idEmpleado;
    private String nombreCompleto;
    private String correo;
    private String telefono;
    private String cargo;
    private Integer idDepartamento;
    private Integer idSupervisor;

    @Data
    public static class Registro {
        private String nombreCompleto;
        private String correo;
        private String telefono;
        private String cargo;
        private Integer idDepartamento;
        private Integer idSupervisor;
        private String password; // 🔑 Aquí está la clave para Swagger
    }
}
