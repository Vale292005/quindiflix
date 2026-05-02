package com.quindiflix.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quindiflix.dto.EpisodioDTO;
import com.quindiflix.mapper.EpisodioMapper;
import com.quindiflix.model.Episodio;
import com.quindiflix.model.Temporada;
import com.quindiflix.repository.EpisodioRepository;
import com.quindiflix.repository.TemporadaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EpisodioService {

    private final EpisodioRepository repository;
    private final EpisodioMapper mapper;
    private final TemporadaRepository temporadaRepository;

    public EpisodioService(EpisodioRepository repository, EpisodioMapper mapper, TemporadaRepository temporadaRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.temporadaRepository = temporadaRepository;
    }

    public List<EpisodioDTO> findAll() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .toList();
    }

    public Optional<EpisodioDTO> findById(Integer id) {
        return repository.findById(id)
                .map(mapper::toDTO);
    }

    @Transactional
    public EpisodioDTO save(EpisodioDTO dto) {
        Episodio entidad = mapper.toEntity(dto);
        if(dto.getIdTemporada() != null) {
            Temporada temporada = temporadaRepository.findById(dto.getIdTemporada())
                    .orElseThrow(() -> new RuntimeException("Temporada no encontrada"));
            entidad.setTemporada(temporada);
        }
        return mapper.toDTO(repository.save(entidad));
    }

    @Transactional
    public EpisodioDTO update(Integer id, EpisodioDTO dto) {
        return repository.findById(id)
                .map(existente -> {
                    existente.setTitulo(dto.getTitulo());
                    existente.setNumero(dto.getNumero());
                    if(dto.getIdTemporada() != null) {
                        Temporada temporada = temporadaRepository.findById(dto.getIdTemporada())
                                .orElseThrow(() -> new RuntimeException("Temporada no encontrada"));
                        existente.setTemporada(temporada);
                    }
                    return mapper.toDTO(repository.save(existente));
                })
                .orElseThrow(() -> new RuntimeException("Episodio no encontrado"));
    }

    @Transactional
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}