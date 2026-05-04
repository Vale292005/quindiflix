package com.quindiflix.service;

import com.quindiflix.repository.CuentaRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.quindiflix.dto.UsuarioDTO;
import com.quindiflix.mapper.UsuarioMapper;
import com.quindiflix.model.Cuenta;
import com.quindiflix.model.Usuario;
import com.quindiflix.repository.PlanRepository;
import com.quindiflix.repository.UsuarioRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final CuentaRepository cuentaRepository;
    private final UsuarioRepository repository;
    private final UsuarioMapper mapper;
    private final PasswordEncoder passwordEncoder;
    private final PlanRepository planRepository;

    public UsuarioService(UsuarioRepository repository, UsuarioMapper mapper, PasswordEncoder passwordEncoder, PlanRepository planRepository, CuentaRepository cuentaRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.passwordEncoder = passwordEncoder;
        this.planRepository = planRepository;
        this.cuentaRepository = cuentaRepository;
    }

    @Transactional
    public UsuarioDTO registrar(UsuarioDTO dto, String passwordPlana) {
        System.out.println("DTO recibido: " + dto);
        Usuario entidad = mapper.toEntity(dto);
        entidad.setPassword(passwordEncoder.encode(passwordPlana));
        Usuario usuario = repository.save(entidad);

        Cuenta cuenta = Cuenta.builder()
                .usuario(usuario)
                .estadoServicio("ACTIVO")
                .fechaUltimoPago(LocalDate.now())
                .plan(planRepository.findByNombrePlan("PLAN_BASICO"))
                .build();
        cuentaRepository.save(cuenta);
        return mapper.toDTO(usuario);
    }

    public List<UsuarioDTO> findAll() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .toList();
    }

    public Optional<UsuarioDTO> findById(Integer id) {
        return repository.findById(id).map(mapper::toDTO);
    }

    @Transactional
    public UsuarioDTO update(Integer id, UsuarioDTO dto) {
        return repository.findById(id)
                .map(existente -> {
                    // Actualización de campos básicos
                    existente.setNombreCompleto(dto.getNombreCompleto());
                    existente.setCorreoElectronico(dto.getCorreoElectronico());
                    existente.setTelefono(dto.getTelefono());
                    existente.setFechaNacimiento(dto.getFechaNacimiento());
                    existente.setCiudadResidencia(dto.getCiudadResidencia());
                    
                    return mapper.toDTO(repository.save(existente));
                })
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con id: " + id));
    }

    @Transactional
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}