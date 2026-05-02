package com.quindiflix.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quindiflix.model.Temporada;


public interface TemporadaRepository extends JpaRepository<Temporada, Integer> {
}
