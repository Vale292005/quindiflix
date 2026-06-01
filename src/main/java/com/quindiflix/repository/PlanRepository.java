package com.quindiflix.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.quindiflix.dto.PlanTransaccionesProjection;
import com.quindiflix.model.Plan;

public interface PlanRepository extends JpaRepository<Plan, Integer> {

    Plan findByNombrePlan(String nombrePlan);

    @Query(value = "SELECT p.nombre AS plan_suscripcion, COUNT(pa.id_pago) AS cantidad_transacciones, SUM(pa.monto) AS ingresos_totales "
            +
            "FROM PAGO pa " +
            "JOIN CUENTA cu ON pa.id_cuenta = cu.id_cuenta " +
            "JOIN PLAN p ON cu.id_plan = p.id_plan " +
            "WHERE pa.estado_pago = 'EXITOSO' " +
            "AND EXTRACT(MONTH FROM pa.fecha_pago) = :mes " +
            "AND EXTRACT(YEAR FROM pa.fecha_pago) = :anio " +
            "GROUP BY p.nombre " +
            "ORDER BY ingresos_totales DESC ", nativeQuery = true)
    List<PlanTransaccionesProjection> findTransaccionesPorPlan(@Param("mes") int mes, @Param("anio") int anio);

}
