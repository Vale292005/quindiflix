package com.quindiflix.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quindiflix.model.Perfil;


public interface PerfilRepository extends JpaRepository<Perfil, Integer> {

    long countByCuenta_IdCuenta(Integer idCuenta);
}
