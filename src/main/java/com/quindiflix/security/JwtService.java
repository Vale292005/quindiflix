package com.quindiflix.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Service;
import org.springframework.web.util.WebUtils;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.function.Function;

@Service
public class JwtService {
    @Value("${quindiflix.jwt.secret}")
    private String secretKey;
    private static final String COOKIE_NAME = "quindiflix_auth";

    // 1. Extraer el correo del token
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    // 2. Generar el token JWT
    public String generateToken(String email) {
        return Jwts.builder()
                .setClaims(new HashMap<>())
                .setSubject(email)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24)) // 24 horas
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }

        // 2. Generar el token JWT
    public String generateToken(String email, Integer idDepartamento) {
        HashMap<String, Object> claims = new HashMap<>();
        claims.put("idDepartamento", idDepartamento);
        claims.put("role", "ROLE_EMPLEADO"); 
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(email)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24)) // 24 horas
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    // 3. Crear la Cookie HttpOnly con el token
    public ResponseCookie createHttpOnlyCookie(String jwt) {
        return ResponseCookie.from(COOKIE_NAME, jwt)
                .httpOnly(true)
                .secure(false) // Cambiar a true si usas HTTPS (producción)
                .path("/")
                .maxAge(24 * 60 * 60) // 1 día
                .sameSite("Lax") // Ayuda contra ataques CSRF
                .build();
    }

    // 4. Obtener el token de la cookie desde la petición
    public String getTokenFromCookie(HttpServletRequest request) {
        Cookie cookie = WebUtils.getCookie(request, COOKIE_NAME);
        return (cookie != null) ? cookie.getValue() : null;
    }

    // 5. Crear cookie vacía para el Logout
    public ResponseCookie cleanCookie() {
        return ResponseCookie.from(COOKIE_NAME, "")
                .path("/")
                .maxAge(0)
                .httpOnly(true)
                .sameSite("Lax")
                .build();
    }

    // Métodos auxiliares de validación
    public boolean isTokenValid(String token, String userEmail) {
        final String username = extractUsername(token);
        return (username.equals(userEmail)) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
