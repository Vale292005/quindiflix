package com.quindiflix.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quindiflix.model.Pago;


public interface PagoRepository extends JpaRepository<Pago, Integer> {
}
