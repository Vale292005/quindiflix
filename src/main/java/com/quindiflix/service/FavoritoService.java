package com.quindiflix.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quindiflix.dto.FavoritoDTO;
import com.quindiflix.mapper.FavoritoMapper;
import com.quindiflix.model.Contenido;
import com.quindiflix.model.Favorito;
import com.quindiflix.model.Perfil;
import com.quindiflix.repository.ContenidoRepository;
import com.quindiflix.repository.FavoritoRepository;
import com.quindiflix.repository.PerfilRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FavoritoService {

    private final FavoritoRepository repository;
    private final FavoritoMapper mapper;
    private final ContenidoRepository contenidoRepository;
    private final PerfilRepository perfilRepository;

    public FavoritoService(FavoritoRepository repository, FavoritoMapper mapper, ContenidoRepository contenidoRepository, PerfilRepository perfilRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.contenidoRepository = contenidoRepository;
        this.perfilRepository = perfilRepository;
    }

    public List<FavoritoDTO> findAll() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .toList();
    }

    public Optional<FavoritoDTO> findById(Integer id) {
        return repository.findById(id)
                .map(mapper::toDTO);
    }

    @Transactional
    public FavoritoDTO save(FavoritoDTO dto) {
        Favorito entidad = mapper.toEntity(dto);
        if(dto.getIdContenido() != null) {
            Contenido contenido = contenidoRepository.findById(dto.getIdContenido())
                    .orElseThrow(() -> new RuntimeException("Contenido no encontrado"));
            entidad.setContenido(contenido);
        }
        if(dto.getIdPerfil() != null) {
            Perfil perfil = perfilRepository.findById(dto.getIdPerfil())
                    .orElseThrow(() -> new RuntimeException("Perfil no encontrado"));
            entidad.setPerfil(perfil);
        }
        return mapper.toDTO(repository.save(entidad));
    }

    @Transactional
    public FavoritoDTO update(Integer id, FavoritoDTO dto) {
        return repository.findById(id)
                .map(existente -> {
                    existente.setFecha(dto.getFecha());
                    if(dto.getIdContenido() != null) {
                        Contenido contenido = contenidoRepository.findById(dto.getIdContenido())
                                .orElseThrow(() -> new RuntimeException("Contenido no encontrado"));
                        existente.setContenido(contenido);
                    }
                    if(dto.getIdPerfil() != null) {
                        Perfil perfil = perfilRepository.findById(dto.getIdPerfil())
                                .orElseThrow(() -> new RuntimeException("Perfil no encontrado"));
                        existente.setPerfil(perfil);
                    }
                    return mapper.toDTO(repository.save(existente));

                })
                .orElseThrow(() -> new RuntimeException("Favorito no encontrado"));
    }

    @Transactional
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}