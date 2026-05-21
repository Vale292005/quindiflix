package com.quindiflix.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quindiflix.model.Empleado;

@Repository

public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {

    Optional<Empleado> findByCorreo(String correo);
}
