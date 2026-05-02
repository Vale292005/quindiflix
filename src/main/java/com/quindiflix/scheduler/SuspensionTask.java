package com.quindiflix.scheduler;

import java.time.LocalDate;
import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.quindiflix.model.Cuenta;
import com.quindiflix.repository.CuentaRepository;

@Component
public class SuspensionTask {

    private final CuentaRepository cuentaRepository;

    public SuspensionTask(CuentaRepository cuentaRepository) {
        this.cuentaRepository = cuentaRepository;
    }

    @Scheduled(cron = "0 0 0 * * ?") // Ejecutar diariamente a medianoche
    @Transactional
    public void suspenderCuentasVencidas() {
        LocalDate fechaLimite = LocalDate.now().minusDays(30);
        int cantidadActualizada = cuentaRepository.suspenderCuentasMorosas(fechaLimite);

        if (cantidadActualizada > 0) {
            System.out.println("LOG: Se han suspendido " + cantidadActualizada + " cuentas automáticamente.");
        }
    }
}
