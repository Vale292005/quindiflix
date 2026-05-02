package com.quindiflix.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.quindiflix.dto.TemporadaDTO;
import com.quindiflix.mapper.TemporadaMapper;
import com.quindiflix.model.Temporada;
import com.quindiflix.model.Contenido;
import com.quindiflix.repository.TemporadaRepository;
import com.quindiflix.repository.ContenidoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TemporadaService {

    private final TemporadaRepository repository;
    private final TemporadaMapper mapper;
    private final ContenidoRepository contenidoRepository;

    public TemporadaService(TemporadaRepository repository, 
                            TemporadaMapper mapper, 
                            ContenidoRepository contenidoRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.contenidoRepository = contenidoRepository;
    }

    public List<TemporadaDTO> findAll() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .toList();
    }

    public Optional<TemporadaDTO> findById(Integer id) {
        return repository.findById(id).map(mapper::toDTO);
    }

    @Transactional
    public TemporadaDTO save(TemporadaDTO dto) {
        Temporada entidad = mapper.toEntity(dto);
        
        // Buscamos el contenido (Serie) al que pertenece
        if (dto.getIdContenido() != null) {
            Contenido contenido = contenidoRepository.findById(dto.getIdContenido())
                    .orElseThrow(() -> new RuntimeException("Contenido (Serie) no encontrado"));
            entidad.setContenido(contenido);
        }
        
        return mapper.toDTO(repository.save(entidad));
    }

    @Transactional
    public TemporadaDTO update(Integer id, TemporadaDTO dto) {
        return repository.findById(id)
                .map(existente -> {
                    existente.setNumeroTemporada(dto.getNumeroTemporada());
                    existente.setTitulo(dto.getTitulo());

                    // Actualizamos la relación si es necesario
                    if (dto.getIdContenido() != null) {
                        Contenido contenido = contenidoRepository.findById(dto.getIdContenido())
                                .orElseThrow(() -> new RuntimeException("Contenido no encontrado"));
                        existente.setContenido(contenido);
                    }

                    return mapper.toDTO(repository.save(existente));
                })
                .orElseThrow(() -> new RuntimeException("Temporada no encontrada con id: " + id));
    }

    @Transactional
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}