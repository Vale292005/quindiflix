package com.quindiflix.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quindiflix.model.Contenido;


public interface ContenidoRepository extends JpaRepository<Contenido, Integer> {

    List<Contenido> findByTipoContenidoIn(List<String> clasificacionesPermitidas);
}
