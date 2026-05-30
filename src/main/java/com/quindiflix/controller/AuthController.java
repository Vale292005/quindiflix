package com.quindiflix.controller;

import com.quindiflix.dto.RegistroRequest;
import com.quindiflix.dto.UsuarioDTO;
import com.quindiflix.model.Empleado;
import com.quindiflix.repository.EmpleadoRepository;
import com.quindiflix.security.JwtService;
import com.quindiflix.service.UsuarioService;

import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UsuarioService usuarioService;

    private final EmpleadoRepository empleadoRepository;
    private final PasswordEncoder passwordEncoder;

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

    @PostMapping("/login-empleado")
    public ResponseEntity<?> loginEmpleado(@RequestBody Map<String, String> request) {
        String email = request.get("correo");
        String password = request.get("password");

        // 1. Buscamos al empleado de forma directa en su repositorio
        Optional<Empleado> empleadoOpt = empleadoRepository.findByCorreo(email);
        if (empleadoOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Credenciales incorrectas o empleado no registrado");
        }

        Empleado empleado = empleadoOpt.get();

        // 2. Validación manual de contraseña usando BCrypt (o tu encoder activo)
        if (!passwordEncoder.matches(password, empleado.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Credenciales incorrectas");
        }

        // 3. Generamos el mismo formato de token y cookie que usan los clientes
        String token = jwtService.generateToken(email,empleado.getIdEmpleado());
        ResponseCookie cookie = jwtService.createHttpOnlyCookie(token);

        // 4. Construimos la respuesta DTO para el frontend evitando datos sensibles
        Map<String, Object> infoEmpleado = new HashMap<>();
        infoEmpleado.put("idEmpleado", empleado.getIdEmpleado());
        infoEmpleado.put("nombre", empleado.getNombreCompleto());
        infoEmpleado.put("correo", empleado.getCorreo());
        infoEmpleado.put("cargo", empleado.getCargo());
        infoEmpleado.put("tipoPerfil", "Empleado"); // 🎯 Clave para activar el modo Empleado en Vue

        infoEmpleado.put("idEmpleado", empleado.getIdEmpleado());
        infoEmpleado.put("token", token); // Opcional: si quieres enviar el token también en el body, aunque ya está en la cookie

        return ResponseEntity.ok()
                .header(HttpHeaders.SET_COOKIE, cookie.toString())
                .body(infoEmpleado);
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout() {
        ResponseCookie cookie = jwtService.cleanCookie();
        return ResponseEntity.ok()
                .header(HttpHeaders.SET_COOKIE, cookie.toString())
                .body("Sesión cerrada");
    }
}