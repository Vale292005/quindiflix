package com.quindiflix.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.quindiflix.model.Favorito;

import jakarta.transaction.Transactional;

@Repository
public interface FavoritoRepository extends JpaRepository<Favorito, Integer> {
    @Query(value = "SELECT c.id_contenido, c.titulo, c.tipo_contenido, c.es_original, c.url_imagen " +
            "FROM FAVORITO f " +
            "JOIN CONTENIDO c ON f.id_contenido = c.id_contenido " +
            "WHERE f.id_perfil = :idPerfil", nativeQuery = true)
    List<Object[]> buscarContenidosFavoritosPorPerfil(@Param("idPerfil") Integer idPerfil);

    @Modifying
    @Transactional
    @Query(value = "BEGIN INSERT INTO FAVORITO (ID_FAVORITO, ID_PERFIL, ID_CONTENIDO, FECHA) VALUES ((SELECT NVL(MAX(ID_FAVORITO), 0) + 1 FROM FAVORITO), :idPerfil, :idContenido, SYSDATE); END;", nativeQuery = true)
    void agregarFavoritoPL(@Param("idPerfil") Integer idPerfil, @Param("idContenido") Integer idContenido);

    // 2. PL/SQL para Eliminar
    @Modifying
    @Transactional
    @Query(value = "BEGIN DELETE FROM FAVORITO WHERE ID_PERFIL = :idPerfil AND ID_CONTENIDO = :idContenido; END;", nativeQuery = true)
    void eliminarFavoritoPL(@Param("idPerfil") Integer idPerfil, @Param("idContenido") Integer idContenido);

    // 3. Consulta para Comprobar si existe
    @Query(value = "SELECT COUNT(1) FROM FAVORITO WHERE ID_PERFIL = :idPerfil AND ID_CONTENIDO = :idContenido", nativeQuery = true)
    Integer comprobarFavoritoNativo(@Param("idPerfil") Integer idPerfil, @Param("idContenido") Integer idContenido);
}
