package com.quindiflix.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.quindiflix.service.AdminBiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/admin/bi")
@RequiredArgsConstructor
// 🔒 Bloqueo de seguridad: Solo cuentas con el rol corporativo de empleado pueden entrar aquí
@PreAuthorize("hasRole('EMPLEADO')") 
public class AdminBiController {

    private final AdminBiService adminBiService;

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
}