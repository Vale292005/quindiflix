package com.quindiflix.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.quindiflix.repository.AdminBiRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminBiService {

    private final AdminBiRepository adminBiRepository;
    private final ObjectMapper objectMapper; // 🎯 Herramienta de Spring para parsear y estructurar JSON

    // Constructor explícito para asegurar la inyección limpia sin depender de Lombok
    public AdminBiService(AdminBiRepository adminBiRepository, ObjectMapper objectMapper) {
        this.adminBiRepository = adminBiRepository;
        this.objectMapper = objectMapper;
    }

    /**
     * Toma el JSON crudo del CLOB de Oracle y lo convierte en un árbol de nodos manipulable.
     */
    public JsonNode obtenerReporteCompleto() {
        try {
            // 1. Llamamos al repositorio para traer el String del procedimiento
            String jsonRaw = adminBiRepository.obtenerCuboAnaliticoJson();
            
            // 2. Parseamos el String para convertirlo en un objeto JSON real de Java
            return objectMapper.readTree(jsonRaw);
            
        } catch (Exception e) {
            throw new RuntimeException("Error crítico en el Servicio al formatear la respuesta analítica de Oracle: " + e.getMessage(), e);
        }
    }
}