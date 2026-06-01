package com.quindiflix.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quindiflix.dto.PlanDTO;
import com.quindiflix.dto.PlanTransaccionesProjection;
import com.quindiflix.mapper.PlanMapper;
import com.quindiflix.model.Plan;
import com.quindiflix.repository.PlanRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PlanService {

    private final PlanRepository repository;
    private final PlanMapper mapper;

    public PlanService(PlanRepository repository, PlanMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<PlanDTO> findAll() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .toList();
    }

    public Optional<PlanDTO> findById(Integer id) {
        return repository.findById(id)
                .map(mapper::toDTO);
    }

    @Transactional
    public PlanDTO save(PlanDTO dto) {
        Plan entity = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(entity));
    }

    @Transactional
    public PlanDTO update(Integer id, PlanDTO dto) {
        return repository.findById(id)
                .map(existente -> {
                    existente.setNombrePlan(dto.getNombrePlan());
                    existente.setPrecio(dto.getPrecio());
                    existente.setCalidadVideo(dto.getCalidadVideo());
                    existente.setCantidadPantallas(dto.getCantidadPantallas());
                    existente.setPerfilesPermitidos(dto.getPerfilesPermitidos());
                    return mapper.toDTO(repository.save(existente));
                })
                .orElseThrow(() -> new RuntimeException("Plan no encontrado"));
    }

    @Transactional
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<PlanTransaccionesProjection> getTransaccionesProjections(int mes, int anio) {
        if (mes < 1 || mes > 12) {
            throw new IllegalArgumentException("El mes debe estar entre 1 y 12");
        }
        if (anio < 1900 || anio > LocalDate.now().getYear()) {
            throw new IllegalArgumentException("El año debe ser válido");
        }
        return repository.findTransaccionesPorPlan(mes, anio);
    }
}