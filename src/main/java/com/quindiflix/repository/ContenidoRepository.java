package com.quindiflix.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.quindiflix.dto.TopContenidoProjection;
import com.quindiflix.model.Contenido;

public interface ContenidoRepository extends JpaRepository<Contenido, Integer> {

    List<Contenido> findByTipoContenidoIn(List<String> clasificacionesPermitidas);

    @Query(value = "SELECT * FROM(" +
            "SELECT c.titulo AS tituloContenido, c.tipo_contenido AS categoria, COUNT(r.id_reproduccion) AS total_reproducciones "
            +
            "FROM REPRODUCCION r " +
            "JOIN CONTENIDO c ON r.id_contenido = c.id_contenido " +
            "JOIN PERFIL p ON r.id_perfil = p.id_perfil " +
            "JOIN CUENTA cu ON p.id_cuenta = cu.id_cuenta " +
            "JOIN USUARIO u ON cu.id_usuario = u.id_usuario " +
            "WHERE UPPER(u.ciudad_residencia) = UPPER(:ciudad) " +
            "GROUP BY c.titulo, c.tipo_contenido " +
            "ORDER BY total_reproducciones DESC " +
            ") " +
            "WHERE ROWNUM <= 10", nativeQuery = true)
    List<TopContenidoProjection> findTop10ByCiudad(@Param("ciudad") String ciudad);
}
