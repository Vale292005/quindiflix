package com.quindiflix.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.quindiflix.dto.UsuarioDTO;
import com.quindiflix.mapper.UsuarioMapper;
import com.quindiflix.model.Usuario;
import com.quindiflix.repository.UsuarioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;
    private final UsuarioMapper mapper;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository repository, UsuarioMapper mapper, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.mapper = mapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public UsuarioDTO registrar(UsuarioDTO dto, String passwordPlana) {
        Usuario entidad = mapper.toEntity(dto);
        entidad.setPassword(passwordEncoder.encode(passwordPlana));
        return mapper.toDTO(repository.save(entidad));
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