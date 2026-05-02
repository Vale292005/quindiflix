package com.quindiflix.dto;

import lombok.Data;

@Data
public class RegistroRequest {
    private UsuarioDTO datosUsuario;
    private String password;
}
