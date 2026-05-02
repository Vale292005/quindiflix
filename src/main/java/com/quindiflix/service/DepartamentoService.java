package com.quindiflix.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quindiflix.dto.DepartamentoDTO;
import com.quindiflix.mapper.DepartamentoMapper;
import com.quindiflix.model.Departamento;
import com.quindiflix.repository.DepartamentoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DepartamentoService {

    private final DepartamentoRepository repository;
    private final DepartamentoMapper mapper;

    public DepartamentoService(DepartamentoRepository repository, DepartamentoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<DepartamentoDTO> findAll() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .toList();
    }

    public Optional<DepartamentoDTO> findById(Integer id) {
        return repository.findById(id)
                .map(mapper::toDTO);
    }

    @Transactional
    public DepartamentoDTO save(DepartamentoDTO dto) {
        Departamento entidad = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(entidad));
    }

    @Transactional
    public DepartamentoDTO update(Integer id, DepartamentoDTO dto) {
        return repository.findById(id)
                .map(existente -> {
                    existente.setNombre(dto.getNombre());
                    return mapper.toDTO(repository.save(existente));
                })
                .orElseThrow(() -> new RuntimeException("Departamento no encontrado"));
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}