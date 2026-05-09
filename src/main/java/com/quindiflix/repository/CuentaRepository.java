package com.quindiflix.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.quindiflix.model.Cuenta;


public interface CuentaRepository extends JpaRepository<Cuenta, Integer> {

    @Modifying
    @Query("UPDATE Cuenta c SET c.estadoServicio = 'SUSPENDIDA' WHERE c.fechaUltimoPago < :fechaLimite AND c.estadoServicio = 'PENDIENTE_PAGO'")
    int suspenderCuentasMorosas(@Param("fechaLimite") LocalDate fechaLimite);

    Optional<Cuenta> findByUsuario_IdUsuario(Integer idUsuario);
}
