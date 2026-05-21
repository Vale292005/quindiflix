package com.quindiflix.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quindiflix.dto.EmpleadoDTO;
import com.quindiflix.exception.BadRequestException;
import com.quindiflix.mapper.EmpleadoMapper;
import com.quindiflix.model.Empleado;
import com.quindiflix.model.Departamento;
import com.quindiflix.repository.DepartamentoRepository;
import com.quindiflix.repository.EmpleadoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService {

    // 🌟 Limpio: Se eliminó la variable duplicada 'empleadoRepository'
    private final EmpleadoRepository repository;
    private final EmpleadoMapper mapper;
    private final DepartamentoRepository departamentoRepository;
    private final PasswordEncoder passwordEncoder;

    // Constructor corregido con las 4 dependencias reales
    public EmpleadoService(EmpleadoRepository repository, 
                           EmpleadoMapper mapper, 
                           DepartamentoRepository departamentoRepository, 
                           PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.mapper = mapper;
        this.departamentoRepository = departamentoRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<EmpleadoDTO> findAll() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .toList();
    }

    public Optional<EmpleadoDTO> findById(Integer id) {
        return repository.findById(id)
                .map(mapper::toDTO);
    }
    
    @Transactional
    public EmpleadoDTO save(EmpleadoDTO.Registro dto) {
        Empleado entidad = mapper.toEntity(dto);
        
        // 1. Validar y encriptar contraseña
        if (dto.getPassword() != null && !dto.getPassword().isBlank()) {
            entidad.setPassword(passwordEncoder.encode(dto.getPassword()));
        } else {
            throw new BadRequestException("La contraseña del empleado es obligatoria.");
        }
        
        // 2. Cargar Departamento de forma obligatoria
        if (dto.getIdDepartamento() != null) {
            Departamento departamento = departamentoRepository.findById(dto.getIdDepartamento())
                    .orElseThrow(() -> new RuntimeException("Departamento no encontrado"));
            entidad.setDepartamento(departamento);
        } else {
            throw new BadRequestException("El departamento es obligatorio.");
        }
        
        // 3. Cargar Supervisor (Usando 'repository' unificado) solo si viene informado
        if (dto.getIdSupervisor() != null) {
            Empleado supervisor = repository.findById(dto.getIdSupervisor())
                    .orElseThrow(() -> new RuntimeException("Supervisor no encontrado"));
            entidad.setSupervisor(supervisor);
        } else {
            entidad.setSupervisor(null); // Aseguramos que sea null explícito en Java
        }
        
        // 4. Validar reglas de negocio antes de guardar
        validarSupervisorYDepartamento(entidad);
        
        // 5. Guardar y mapear a DTO de salida
        return mapper.toDTO(repository.save(entidad));
    }

    @Transactional
    public EmpleadoDTO update(Integer id, EmpleadoDTO dto) {
        return repository.findById(id)
                .map(existente -> {
                    existente.setNombreCompleto(dto.getNombreCompleto());
                    existente.setCargo(dto.getCargo());
                    existente.setCorreo(dto.getCorreo());
                    existente.setTelefono(dto.getTelefono());
                    
                    if (dto.getIdSupervisor() != null) {
                        Empleado supervisor = repository.findById(dto.getIdSupervisor())
                                .orElseThrow(() -> new RuntimeException("Supervisor no encontrado"));
                        existente.setSupervisor(supervisor);
                    } else {
                        existente.setSupervisor(null);
                    }
                    
                    if (dto.getIdDepartamento() != null) {
                        Departamento departamento = departamentoRepository.findById(dto.getIdDepartamento())
                                .orElseThrow(() -> new RuntimeException("Departamento no encontrado"));
                        existente.setDepartamento(departamento);
                    }
                    
                    validarSupervisorYDepartamento(existente);
                    return mapper.toDTO(repository.save(existente));
                })
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado"));
    }

    @Transactional
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    // 🌟 Método de validación blindado a prueba de NullPointerExceptions
    private void validarSupervisorYDepartamento(Empleado empleado) {
        // Si no tiene supervisor asignado, no hay regla de negocio de coincidencia que evaluar.
        if (empleado.getSupervisor() == null) {
            return; 
        }

        if (empleado.getDepartamento() == null) {
            throw new BadRequestException("El empleado debe tener un departamento asignado.");
        }
        
        if (empleado.getSupervisor().getDepartamento() == null) {
            throw new BadRequestException("El supervisor asignado no tiene un departamento configurado.");
        }

        Integer deptoEmpleado = empleado.getDepartamento().getIdDepartamento();
        Integer deptoSupervisor = empleado.getSupervisor().getDepartamento().getIdDepartamento();

        if (!deptoEmpleado.equals(deptoSupervisor)) {
            throw new BadRequestException("El supervisor debe pertenecer al mismo departamento que el empleado.");
        }
    }
}