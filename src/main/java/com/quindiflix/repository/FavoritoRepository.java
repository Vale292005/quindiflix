package com.quindiflix.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quindiflix.model.Favorito;


public interface FavoritoRepository extends JpaRepository<Favorito, Integer> {
}
