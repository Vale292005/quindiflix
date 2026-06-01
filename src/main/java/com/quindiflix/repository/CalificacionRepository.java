package com.quindiflix.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.quindiflix.dto.CalificacionPromedioProjection;
import com.quindiflix.model.Calificacion;

public interface CalificacionRepository extends JpaRepository<Calificacion, Integer> {
    @Query(value = "SELECT c.tipo_contenido AS formato_categoria, ROUND(AVG(cal.estrellas),2) AS calificacion_promedio, COUNT(cal.id_calificacion) AS total_calificaciones " +
        "FROM CALIFICACION cal " +
        "JOIN CONTENIDO c ON cal.id_contenido = c.id_contenido " +
        "JOIN CONTENIDO_GENERO cg ON c.id_contenido = cg.id_contenido " +
        "JOIN GENERO g ON cg.id_genero = g.id_genero " +
        "WHERE UPPER(g.nombre) = UPPER(:genero) " +
        "GROUP BY c.tipo_contenido " +
        "ORDER BY calificacion_promedio DESC", nativeQuery = true)
    List<CalificacionPromedioProjection> findCalificacionPromedioByGenero(@Param("genero") String genero);
}
