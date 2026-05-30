package com.quindiflix.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.quindiflix.service.AdminBiService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/admin/bi")
@RequiredArgsConstructor
// 🔒 Bloqueo de seguridad: Solo cuentas con el rol corporativo de empleado
// pueden entrar aquí
@PreAuthorize("hasRole('EMPLEADO')")
public class AdminBiController {

    private final AdminBiService adminBiService;
    private final JdbcTemplate jdbcTemplate;

    @GetMapping("/consumo")
    public ResponseEntity<JsonNode> getReporteConsumo() {
        JsonNode fullReport = adminBiService.obtenerReporteCompleto();
        return ResponseEntity.ok(fullReport.get("ciudadPlan")); // 👈 Entrega el ROLLUP
    }

    @GetMapping("/financiero")
    public ResponseEntity<JsonNode> getReporteFinanciero() {
        JsonNode fullReport = adminBiService.obtenerReporteCompleto();
        return ResponseEntity.ok(fullReport.get("dispositivos")); // 👈 Entrega el UNPIVOT
    }

    @GetMapping("/equipo")
    public ResponseEntity<JsonNode> getReporteEquipo() {
        JsonNode fullReport = adminBiService.obtenerReporteCompleto();
        return ResponseEntity.ok(fullReport.get("matrizGeneros")); // 👈 Entrega el PIVOT
    }

    @GetMapping("/usuarios-por-ciudad")
    public ResponseEntity<?> obtenerUsuariosPorCiudad(@RequestParam(name = "ciudad") String ciudad) {
        try {
            String sql = "SELECT u.nombre_completo, u.correo_electronico, c.estado_servicio, p.nombre_plan " +
                    "FROM USUARIO u " +
                    "JOIN CUENTA c ON u.id_usuario = c.id_usuario " +
                    "JOIN PLAN p ON c.id_plan = p.id_plan " +
                    "WHERE UPPER(u.ciudad_residencia) = UPPER(?) ";

            List<Map<String, Object>> usuarios = jdbcTemplate.queryForList(sql, ciudad);
            return new ResponseEntity<>(usuarios, HttpStatus.OK);
        } catch (Exception e) {
            String errorResponse = "{\"error\": \"Falla al consultar usuarios por localización\", \"detalle\": \""
                    + e.getMessage() + "\"}";
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/historial-transacciones")
    public ResponseEntity<?> obtenerHIstorialTransacciones(@RequestParam(name = "idCuenta") Long idCuenta) {
        try {
            String sql = "SELECT pg.id_pago, pg.monto, pg.fecha_pago, pg.estado_pago " +
                    "FROM PAGO pg " +
                    "WHERE pg.id_cuenta = ?" +
                    "ORDER BY pg.fecha_pago DESC";
            List<Map<String, Object>> transacciones = jdbcTemplate.queryForList(sql, new Object[] { idCuenta });
            return new ResponseEntity<>(transacciones, HttpStatus.OK);
        } catch (Exception e) {
            String errorResponse = "{\"error\": \"Falla al consultar historial de transacciones\", \"detalle\": \""
                    + e.getMessage() + "\"}";
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/control-temporal")
    public ResponseEntity<?> obtenerControlTemporal(@RequestParam(name = "fechaInicio") String fechaInicio,
                                                    @RequestParam(name = "fechaFin") String fechaFin) {
        try {
            // 1. Convertimos los Strings "YYYY-MM-DD" de Vue a objetos java.sql.Date puros
            java.sql.Date sqlInicio = java.sql.Date.valueOf(fechaInicio);
            java.sql.Date sqlFin = java.sql.Date.valueOf(fechaFin);

            // 2. Consulta SQL usando "fecha_hora_inicio" (Nombre real de tu columna TIMESTAMP)
            String sql = "SELECT r.id_reproduccion, p.nombre AS nombre_perfil, cont.titulo, r.fecha_hora_inicio " +
                         "FROM REPRODUCCION r " +
                         "JOIN PERFIL p ON r.id_perfil = p.id_perfil " +
                         "JOIN CONTENIDO cont ON r.id_contenido = cont.id_contenido " +
                         "WHERE TRUNC(r.fecha_hora_inicio) BETWEEN ? AND ?";

            // 3. Pasamos las fechas nativas al jdbcTemplate
            List<Map<String, Object>> reproducciones = jdbcTemplate.queryForList(sql, new Object[]{ sqlInicio, sqlFin });
            return new ResponseEntity<>(reproducciones, HttpStatus.OK);
            
        } catch (Exception e) {
            e.printStackTrace(); // Imprime el error real en tu consola negra de Spring Boot
            String errorResponse = "{\"error\": \"Falla en consulta temporal de Oracle\", \"detalle\": \""
                    + e.getMessage().replace("\"", "\\\"") + "\"}";
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}