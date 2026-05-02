package com.quindiflix.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quindiflix.model.Departamento;


public interface DepartamentoRepository extends JpaRepository<Departamento, Integer> {
}
