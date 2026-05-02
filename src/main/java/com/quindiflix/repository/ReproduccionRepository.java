package com.quindiflix.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quindiflix.model.Reproduccion;


public interface ReproduccionRepository extends JpaRepository<Reproduccion, Integer> {
}
