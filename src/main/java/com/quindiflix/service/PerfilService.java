package com.quindiflix.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quindiflix.dto.PerfilDTO;
import com.quindiflix.mapper.PerfilMapper;
import com.quindiflix.model.Cuenta;
import com.quindiflix.model.Perfil;
import com.quindiflix.repository.CuentaRepository;
import com.quindiflix.repository.PerfilRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PerfilService {

    private final PerfilRepository repository;
    private final PerfilMapper mapper;
    private final CuentaRepository cuentaRepository;

    public PerfilService(PerfilRepository repository, PerfilMapper mapper, CuentaRepository cuentaRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.cuentaRepository = cuentaRepository;
    }

    public List<PerfilDTO> findAll() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .toList();
    }

    public Optional<PerfilDTO> findById(Integer id) {
        return repository.findById(id)
                .map(mapper::toDTO);
    }

    @Transactional
    public PerfilDTO save(PerfilDTO dto) {
        Perfil entidad = mapper.toEntity(dto);
        if(dto.getIdCuenta() != null) {
            Cuenta cuenta = cuentaRepository.findById(dto.getIdCuenta())
                    .orElseThrow(() -> new RuntimeException("Cuenta no encontrada"));
            entidad.setCuenta(cuenta);
        }
        return mapper.toDTO(repository.save(entidad));
    }

    @Transactional
    public PerfilDTO update (Integer id, PerfilDTO dto) {
        return repository.findById(id)
                .map(existente -> {
                    existente.setNombre(dto.getNombre());
                    existente.setAvatar(dto.getAvatar());
                    existente.setTipoPerfil(dto.getTipoPerfil());
                    if(dto.getIdCuenta() != null) {
                        Cuenta cuenta = cuentaRepository.findById(dto.getIdCuenta())
                                .orElseThrow(() -> new RuntimeException("Cuenta no encontrada"));
                        existente.setCuenta(cuenta);
                    }
                    return mapper.toDTO(repository.save(existente));
                })
                .orElseThrow(() -> new RuntimeException("Perfil no encontrado"));
    }

    @Transactional
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}