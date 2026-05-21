package com.quindiflix.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.quindiflix.model.Perfil;

public interface PerfilRepository extends JpaRepository<Perfil, Integer> {

    long countByCuenta_IdCuenta(Integer idCuenta);

    @Query(value = "SELECT id_perfil, id_cuenta, nombre, avatar, tipo_perfil FROM PERFIL WHERE id_cuenta = :idCuenta", nativeQuery = true)
    List<Object[]> buscarPerfilesPorCuentaNativo(@Param("idCuenta") Integer idCuenta);
}
