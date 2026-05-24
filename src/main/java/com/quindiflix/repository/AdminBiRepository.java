package com.quindiflix.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.sql.Clob;
import java.util.Map;

@Repository
public class AdminBiRepository {

    private final JdbcTemplate jdbcTemplate;

    // Escribimos el constructor explícito para asegurar la inyección sin depender de Lombok
    public AdminBiRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Llama a tu procedimiento real de Oracle 'SP_GET_REPORTE_CONSUMO_JSON'
     * y extrae el CLOB que contiene la analítica de la plataforma.
     */
    public String obtenerCuboAnaliticoJson() {
        try {
            // Configura el llamado directo al procedimiento nativo
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withProcedureName("SP_GET_REPORTE_CONSUMO_JSON");

            // Ejecuta el procedimiento en Oracle
            Map<String, Object> result = jdbcCall.execute(new MapSqlParameterSource());

            // Recupera el parámetro OUT (Oracle por defecto lo mapea con el nombre de la variable en mayúsculas)
            Object clobObject = result.get("P_JSON_RESULTADO");

            // Convertimos el CLOB de Oracle a un String común de Java
            if (clobObject instanceof Clob) {
                Clob clob = (Clob) clobObject;
                return clob.getSubString(1, (int) clob.length());
            } else if (clobObject != null) {
                return clobObject.toString();
            }

            return "{}"; // Si llega vacío, devuelve un objeto JSON básico para evitar romper el flujo
            
        } catch (Exception e) {
            throw new RuntimeException("Error crítico en Oracle al ejecutar SP_GET_REPORTE_CONSUMO_JSON: " + e.getMessage(), e);
        }
    }
}