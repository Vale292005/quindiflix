package com.quindiflix.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quindiflix.model.Categoria;


public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
}
