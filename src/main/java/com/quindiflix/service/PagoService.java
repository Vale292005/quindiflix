package com.quindiflix.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quindiflix.dto.PagoDTO;
import com.quindiflix.mapper.PagoMapper;
import com.quindiflix.model.Cuenta;
import com.quindiflix.model.Pago;
import com.quindiflix.repository.CuentaRepository;
import com.quindiflix.repository.PagoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PagoService {

    private final PagoRepository repository;
    private final PagoMapper mapper;
    private final CuentaRepository cuentaRepository;

    public PagoService(PagoRepository repository, PagoMapper mapper, CuentaRepository cuentaRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.cuentaRepository = cuentaRepository;
    }

    public List<PagoDTO> findAll() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .toList();
    }

    public Optional<PagoDTO> findById(Integer id) {
        return repository.findById(id)
                .map(mapper::toDTO);
    }

    @Transactional
    public PagoDTO save(PagoDTO dto) {
        Pago entity = mapper.toEntity(dto);
        if(dto.getIdCuenta() != null) {
            Cuenta cuenta = cuentaRepository.findById(dto.getIdCuenta())
                    .orElseThrow(() -> new RuntimeException("Cuenta no encontrada"));
            entity.setCuenta(cuenta);
        }
        return mapper.toDTO(repository.save(entity));
    }

    @Transactional
    public PagoDTO update(Integer id, PagoDTO dto) {
        return repository.findById(id)
                .map(existente -> {
                    existente.setFechaPago(dto.getFechaPago());
                    existente.setMonto(dto.getMonto());
                    existente.setMetodoPago(dto.getMetodoPago());
                    existente.setEstadoPago(dto.getEstadoPago());
                    if(dto.getIdCuenta() != null) {
                        Cuenta cuenta = cuentaRepository.findById(dto.getIdCuenta())
                                .orElseThrow(() -> new RuntimeException("Cuenta no encontrada"));
                        existente.setCuenta(cuenta);
                    }
                    return mapper.toDTO(repository.save(existente));
                })
                 .orElseThrow(() -> new RuntimeException("Pago no encontrado"));
    }

    @Transactional
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}