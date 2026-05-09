package com.quindiflix.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quindiflix.dto.CuentaDTO;
import com.quindiflix.mapper.CuentaMapper;
import com.quindiflix.model.Cuenta;
import com.quindiflix.model.Plan;
import com.quindiflix.model.Usuario;
import com.quindiflix.repository.CuentaRepository;
import com.quindiflix.repository.PlanRepository;
import com.quindiflix.repository.UsuarioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CuentaService {

    private final CuentaRepository repository;
    private final CuentaMapper mapper;
    private final UsuarioRepository usuarioRepository;
    private final PlanRepository planRepository;

    public CuentaService(CuentaRepository repository, CuentaMapper mapper, UsuarioRepository usuarioRepository, PlanRepository planRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.usuarioRepository = usuarioRepository;
        this.planRepository = planRepository;
    }

    public List<CuentaDTO> findAll() {
        return repository.findAll().stream()
                .map(mapper::toDTO) 
                .toList();
    }

    public Optional<CuentaDTO> findById(Integer id) {
        return repository.findById(id)
                .map(mapper::toDTO);
    }

    @Transactional
    public CuentaDTO save(CuentaDTO dto) {
        Cuenta entidad= mapper.toEntity(dto);
        if(dto.getIdUsuario() != null) {
            Usuario usuario = usuarioRepository.findById(dto.getIdUsuario())
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
            entidad.setUsuario(usuario);
        }
        if(dto.getIdPlan() != null) {
            Plan plan = planRepository.findById(dto.getIdPlan())
                    .orElseThrow(() -> new RuntimeException("Plan no encontrado"));
            entidad.setPlan(plan);
        }
        return mapper.toDTO(repository.save(entidad));
    }

    @Transactional
    public CuentaDTO update(Integer id, CuentaDTO dto) {
        return repository.findById(id)
                .map(existente -> {
                    existente.setEstadoServicio(dto.getEstadoServicio());
                    existente.setFechaUltimoPago(dto.getFechaUltimoPago());
                    if(dto.getIdUsuario() != null) {
                        Usuario usuario = usuarioRepository.findById(dto.getIdUsuario())
                                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
                        existente.setUsuario(usuario);
                    }
                    if(dto.getIdPlan() != null) {
                        Plan plan = planRepository.findById(dto.getIdPlan())
                                .orElseThrow(() -> new RuntimeException("Plan no encontrado"));
                        existente.setPlan(plan);
                    }
                    return mapper.toDTO(repository.save(existente));
                })
                .orElseThrow(() -> new RuntimeException("Cuenta no encontrada"));
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public Optional<CuentaDTO> findByUsuarioId(Integer usuarioId) {
        return repository.findByUsuario_IdUsuario(usuarioId)
                .map(mapper::toDTO);
    }
}