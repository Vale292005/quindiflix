package com.quindiflix.dto;

import lombok.Data;
@Data
public class RegistroEmpleadoRequest {
    private EmpleadoDTO datosEmpleado; // Trae el nombre, correo, cargo, id_departamento, etc.
    private String password;           // Contraseña plana corporativa a encriptar
}