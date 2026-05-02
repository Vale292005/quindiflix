package com.quindiflix.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.quindiflix.dto.ReproduccionDTO;
import com.quindiflix.mapper.ReproduccionMapper;
import com.quindiflix.model.Reproduccion;
import com.quindiflix.model.Perfil;
import com.quindiflix.model.Contenido;
import com.quindiflix.model.Episodio;
import com.quindiflix.repository.ReproduccionRepository;
import com.quindiflix.repository.PerfilRepository;
import com.quindiflix.repository.ContenidoRepository;
import com.quindiflix.repository.EpisodioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ReproduccionService {

    private final ReproduccionRepository repository;
    private final ReproduccionMapper mapper;
    private final PerfilRepository perfilRepository;
    private final ContenidoRepository contenidoRepository;
    private final EpisodioRepository episodioRepository;

    public ReproduccionService(ReproduccionRepository repository, 
                              ReproduccionMapper mapper,
                              PerfilRepository perfilRepository,
                              ContenidoRepository contenidoRepository,
                              EpisodioRepository episodioRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.perfilRepository = perfilRepository;
        this.contenidoRepository = contenidoRepository;
        this.episodioRepository = episodioRepository;
    }

    public List<ReproduccionDTO> findAll() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .toList();
    }

    public Optional<ReproduccionDTO> findById(Integer id) {
        return repository.findById(id).map(mapper::toDTO);
    }

    @Transactional
    public ReproduccionDTO save(ReproduccionDTO dto) {
        Reproduccion entidad = mapper.toEntity(dto);
        asignarRelaciones(entidad, dto);
        return mapper.toDTO(repository.save(entidad));
    }

    @Transactional
    public ReproduccionDTO update(Integer id, ReproduccionDTO dto) {
        return repository.findById(id)
                .map(existente -> {
                    existente.setFechaHoraInicio(dto.getFechaHoraInicio());
                    existente.setFechaHoraFin(dto.getFechaHoraFin());
                    existente.setDispositivo(dto.getDispositivo());
                    existente.setPorcentajeAvance(dto.getPorcentajeAvance());
                    
                    asignarRelaciones(existente, dto);
                    
                    return mapper.toDTO(repository.save(existente));
                })
                .orElseThrow(() -> new RuntimeException("Reproducción no encontrada con id: " + id));
    }

    @Transactional
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    /**
     * Método privado para evitar repetir código en save y update
     */
    private void asignarRelaciones(Reproduccion entidad, ReproduccionDTO dto) {
        if (dto.getIdPerfil() != null) {
            Perfil perfil = perfilRepository.findById(dto.getIdPerfil())
                    .orElseThrow(() -> new RuntimeException("Perfil no encontrado"));
            entidad.setPerfil(perfil);
        }

        if (dto.getIdContenido() != null) {
            Contenido contenido = contenidoRepository.findById(dto.getIdContenido())
                    .orElseThrow(() -> new RuntimeException("Contenido no encontrado"));
            entidad.setContenido(contenido);
        }

        // El episodio es opcional porque si es una película, no tiene episodio
        if (dto.getIdEpisodio() != null) {
            Episodio episodio = episodioRepository.findById(dto.getIdEpisodio())
                    .orElseThrow(() -> new RuntimeException("Episodio no encontrado"));
            entidad.setEpisodio(episodio);
        } else {
            entidad.setEpisodio(null);
        }
    }
}