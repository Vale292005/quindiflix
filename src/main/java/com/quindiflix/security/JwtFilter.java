package com.quindiflix.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain
    ) throws ServletException, IOException {
        
        // 1. Intentamos obtener el token de la Cookie
        final String jwt = jwtService.getTokenFromCookie(request);
        final String userEmail;

        // Si no hay token, seguimos con la cadena de filtros (Spring decidirá si la ruta es pública o no)
        if (jwt == null) {
            filterChain.doFilter(request, response);
            return;
        }

        userEmail = jwtService.extractUsername(jwt);

        // 2. Si hay email y el usuario no está ya autenticado en el contexto
        if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(userEmail);

            // 3. Si el token es válido, creamos la autenticación
            if (jwtService.isTokenValid(jwt, userDetails.getUsername())) {

                Integer idDepartamento = jwtService.extractClaim(jwt, claims -> claims.get("idDepartamento", Integer.class));
                String role = jwtService.extractClaim(jwt, claims -> claims.get("role", String.class));
                if (role == null) {
                    role = userDetails.getAuthorities().iterator().next().getAuthority();
                }

                // Creamos la instancia de nuestro nuevo molde UsuarioPrincipal pasándole los 4 datos
                UsuarioPrincipal usuarioPrincipal = new UsuarioPrincipal(
                        userDetails.getUsername(),
                        userDetails.getPassword(),
                        role,
                        idDepartamento // 👈 Guardado de manera segura en el contexto por cada Request
                );

                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        usuarioPrincipal,
                        null,
                        usuarioPrincipal.getAuthorities()
                );
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                
                // 4. Seteamos la autenticación en el contexto de seguridad
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        filterChain.doFilter(request, response);
    }
}
