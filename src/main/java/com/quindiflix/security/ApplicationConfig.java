package com.quindiflix.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.quindiflix.repository.EmpleadoRepository;
import com.quindiflix.repository.UsuarioRepository;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {

private final UsuarioRepository usuarioRepository;
private final EmpleadoRepository empleadoRepository; 

@Bean
public UserDetailsService userDetailsService() {
    return username -> {
        // 1. Intentar buscar primero en la tabla de Clientes/Usuarios comunes
        var usuarioOpt = usuarioRepository.findByCorreoElectronico(username);
        if (usuarioOpt.isPresent()) {
            var u = usuarioOpt.get();
            return org.springframework.security.core.userdetails.User.builder()
                    .username(u.getCorreoElectronico())
                    .password(u.getPassword())
                    .roles("USER") // 🎯 Asigna ROLE_USER automáticamente
                    .build();
        }

        // 2. Si no es un cliente, buscar en la tabla de Empleados corporativos
        // 💡 NOTA: Asegúrate de tener inyectado 'empleadoRepository' arriba en esta clase
        var empleadoOpt = empleadoRepository.findByCorreo(username);
        if (empleadoOpt.isPresent()) {
            var e = empleadoOpt.get();
            return org.springframework.security.core.userdetails.User.builder()
                    .username(e.getCorreo())
                    .password(e.getPassword())
                    .roles("EMPLEADO") // 🎯 Asigna ROLE_EMPLEADO automáticamente
                    .build();
        }

        // 3. Si no existe en ninguna de las dos tablas de Oracle
        throw new org.springframework.security.core.userdetails.UsernameNotFoundException(
                "Usuario o Empleado no encontrado con el correo: " + username);
    };
}
    

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}