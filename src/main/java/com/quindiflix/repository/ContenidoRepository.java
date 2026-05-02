package com.quindiflix.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quindiflix.model.Contenido;


public interface ContenidoRepository extends JpaRepository<Contenido, Integer> {
}
