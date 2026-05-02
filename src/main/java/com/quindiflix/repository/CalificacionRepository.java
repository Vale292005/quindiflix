package com.quindiflix.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quindiflix.model.Calificacion;

public interface CalificacionRepository extends JpaRepository<Calificacion, Integer> {
}
