package com.quindiflix.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quindiflix.dto.GeneroDTO;
import com.quindiflix.mapper.GeneroMapper;
import com.quindiflix.model.Genero;
import com.quindiflix.repository.GeneroRepository;

import java.util.List;
import java.util.Optional;

@Service
public class GeneroService {

    private final GeneroRepository repository;
    private final GeneroMapper mapper;

    public GeneroService(GeneroRepository repository, GeneroMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<GeneroDTO> findAll() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .toList();
    }

    public Optional<GeneroDTO> findById(Integer id) {
        return repository.findById(id)
                .map(mapper::toDTO);
    }

    @Transactional
    public GeneroDTO save(GeneroDTO dto) {
        Genero entity = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(entity));
    }

    @Transactional
    public GeneroDTO update(Integer id, GeneroDTO dto) {
        return repository.findById(id)
                .map(existente -> {
                    existente.setNombre(dto.getNombre());
                    return mapper.toDTO(repository.save(existente));
                })
                .orElseThrow(() -> new RuntimeException("Género no encontrado"));
    }

    @Transactional
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}