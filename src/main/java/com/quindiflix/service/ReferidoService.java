package com.quindiflix.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quindiflix.dto.ReferidoDTO;
import com.quindiflix.mapper.ReferidoMapper;
import com.quindiflix.model.Referido;
import com.quindiflix.model.Usuario;
import com.quindiflix.repository.ReferidoRepository;
import com.quindiflix.repository.UsuarioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ReferidoService {

    private final ReferidoRepository repository;
    private final ReferidoMapper mapper;
    private final UsuarioRepository usuarioRepository;

    public ReferidoService(ReferidoRepository repository, ReferidoMapper mapper, UsuarioRepository usuarioRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.usuarioRepository = usuarioRepository;
    }

    public List<ReferidoDTO> findAll() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .toList();
    }

    public Optional<ReferidoDTO> findById(Integer id) {
        return repository.findById(id)
                .map(mapper::toDTO);
    }
    
    @Transactional
    public ReferidoDTO save(ReferidoDTO dto) {
        Referido entity = mapper.toEntity(dto);
        if(dto.getIdUsuarioReferido() != null) {
            Usuario usuarioReferido = usuarioRepository.findById(dto.getIdUsuarioReferido())
                    .orElseThrow(() -> new RuntimeException("Usuario referido no encontrado"));
            entity.setReferido(usuarioReferido);
        }
        if(dto.getIdUsuarioReferidor() != null) {
            Usuario usuarioReferidor = usuarioRepository.findById(dto.getIdUsuarioReferidor())
                    .orElseThrow(() -> new RuntimeException("Usuario referidor no encontrado"));
            entity.setReferidor(usuarioReferidor);
        }
        return mapper.toDTO(repository.save(entity));
    }

    @Transactional
    public ReferidoDTO update(Integer id, ReferidoDTO dto) {
        return repository.findById(id)
                .map(existente -> {
                    existente.setFechaRegistro(dto.getFechaRegistro());
                    existente.setActivo(dto.getActivo());
                    if(dto.getIdUsuarioReferido() != null) {
                        Usuario usuarioReferido = usuarioRepository.findById(dto.getIdUsuarioReferido())
                                .orElseThrow(() -> new RuntimeException("Usuario referido no encontrado"));
                        existente.setReferido(usuarioReferido);
                    }
                    if(dto.getIdUsuarioReferidor() != null) {
                        Usuario usuarioReferidor = usuarioRepository.findById(dto.getIdUsuarioReferidor())
                                .orElseThrow(() -> new RuntimeException("Usuario referidor no encontrado"));
                        existente.setReferidor(usuarioReferidor);
                    }
                    return mapper.toDTO(repository.save(existente));
                })
                .orElseThrow(() -> new RuntimeException("Referido no encontrado"));
    }

    @Transactional
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}