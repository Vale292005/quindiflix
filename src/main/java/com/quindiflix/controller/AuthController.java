package com.quindiflix.controller;

import com.quindiflix.dto.RegistroRequest;
import com.quindiflix.dto.UsuarioDTO;
import com.quindiflix.security.JwtService;
import com.quindiflix.service.UsuarioService;

import lombok.RequiredArgsConstructor;

import java.util.Optional;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UsuarioService usuarioService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody RegistroRequest request) {
        // 1. Extraemos el email desde datosUsuario y el password del root del DTO
        String email = request.getDatosUsuario().getCorreoElectronico();
        String password = request.getPassword();

        // 2. Autenticar
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, password)
        );

        // 3. Generar Token usando el email extraído
        String token = jwtService.generateToken(email);

        // 4. Crear Cookie
        ResponseCookie cookie = jwtService.createHttpOnlyCookie(token);
        Optional<UsuarioDTO> usuarioCompleto = usuarioService.findByEmail(email);

        return ResponseEntity.ok()
                .header(HttpHeaders.SET_COOKIE, cookie.toString())
                .body(usuarioCompleto);
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout() {
        ResponseCookie cookie = jwtService.cleanCookie();
        return ResponseEntity.ok()
                .header(HttpHeaders.SET_COOKIE, cookie.toString())
                .body("Sesión cerrada");
    }
}