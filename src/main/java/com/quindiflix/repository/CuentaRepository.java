package com.quindiflix.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quindiflix.model.Cuenta;


public interface CuentaRepository extends JpaRepository<Cuenta, Integer> {
}
