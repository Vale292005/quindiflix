package com.quindiflix.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quindiflix.model.Episodio;


public interface EpisodioRepository extends JpaRepository<Episodio, Integer> {
}
