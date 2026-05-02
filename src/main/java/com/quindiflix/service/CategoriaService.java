package com.quindiflix.service;

import org.springframework.stereotype.Service;

import com.quindiflix.dto.CategoriaDTO;
import com.quindiflix.mapper.CategoriaMapper;
import com.quindiflix.model.Categoria;
import com.quindiflix.repository.CategoriaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    private final CategoriaRepository repository;
    private final CategoriaMapper mapper;
    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository repository, CategoriaMapper mapper, CategoriaRepository categoriaRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.categoriaRepository = categoriaRepository;
    }

    public List<CategoriaDTO> findAll() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .toList();
    }

    public Optional<CategoriaDTO> findById(Integer id) {
        return repository.findById(id).map(mapper::toDTO);
    }

    public CategoriaDTO save(CategoriaDTO dto) {
        Categoria entity = mapper.toEntity(dto);
        Categoria saved = repository.save(entity);
        return mapper.toDTO(saved);
    }

    public CategoriaDTO update(Integer id, CategoriaDTO dto) {
        return repository.findById(id)
                .map(existente -> {
                    existente.setNombre(dto.getNombre());
                    if(dto.getIdCategoria() != null) {
                        Categoria categoria = categoriaRepository.findById(dto.getIdCategoria())
                                .orElseThrow(() -> new RuntimeException("Categoría padre no encontrada"));
                        existente.setIdCategoria(categoria.getIdCategoria());
                    }
                    return mapper.toDTO(repository.save(existente));
                })
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}