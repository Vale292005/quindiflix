package com.quindiflix.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quindiflix.dto.CalificacionDTO;
import com.quindiflix.dto.CalificacionPromedioProjection;
import com.quindiflix.mapper.CalificacionMapper;
import com.quindiflix.model.Calificacion;
import com.quindiflix.model.Perfil;
import com.quindiflix.model.Contenido;
import com.quindiflix.repository.CalificacionRepository;
import com.quindiflix.repository.ContenidoRepository;
import com.quindiflix.repository.PerfilRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CalificacionService {

    private final CalificacionRepository repository;
    private final CalificacionMapper mapper;
    private final PerfilRepository perfilRepository;
    private final ContenidoRepository contenidoRepository;

    public CalificacionService(CalificacionRepository repository, CalificacionMapper mapper, PerfilRepository perfilRepository, ContenidoRepository contenidoRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.perfilRepository = perfilRepository;
        this.contenidoRepository = contenidoRepository;
    }

    public List<CalificacionDTO> findAll() {
        return repository.findAll().stream()
                .map(mapper::toDTO) // Convertimos a DTO
                .toList();
    }

    public Optional<CalificacionDTO> findById(Integer id) {
        return repository.findById(id).map(mapper::toDTO);
    }

    @Transactional
    public CalificacionDTO save(CalificacionDTO dto) {
        Calificacion entity = mapper.toEntity(dto);
        Calificacion saved = repository.save(entity);
        return mapper.toDTO(saved);
    }
    @Transactional
    public CalificacionDTO update(Integer id, CalificacionDTO dto) {
        return repository.findById(id)
                .map(existente -> {
                    existente.setEstrellas(dto.getEstrellas());
                    existente.setFecha(dto.getFecha());
                    if(dto.getIdPerfil() != null) {
                        Perfil perfil = perfilRepository.findById(dto.getIdPerfil())
                                .orElseThrow(() -> new RuntimeException("Perfil no encontrado"));
                        existente.setPerfil(perfil);
                    }
                    if(dto.getIdContenido() != null) {
                        Contenido contenido = contenidoRepository.findById(dto.getIdContenido())
                                .orElseThrow(() -> new RuntimeException("Contenido no encontrado"));
                        existente.setContenido(contenido);
                    }
                    return mapper.toDTO(repository.save(existente));
                })
                .orElseThrow(() -> new RuntimeException("Calificación no encontrada"));
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public List<CalificacionPromedioProjection> getCalificacionPromedioByGenero(String genero) {
         if (genero == null || genero.trim().isEmpty()) {
             throw new IllegalArgumentException("El parámetro 'genero' no puede ser nulo o vacío");
         }
         return repository.findCalificacionPromedioByGenero(genero.trim());
     }
}