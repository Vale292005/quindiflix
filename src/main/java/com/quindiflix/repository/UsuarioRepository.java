package com.quindiflix.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quindiflix.model.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByCorreoElectronico(String correoElectronico);
}
