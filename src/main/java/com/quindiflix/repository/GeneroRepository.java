package com.quindiflix.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quindiflix.model.Genero;


public interface GeneroRepository extends JpaRepository<Genero, Integer> {
}
