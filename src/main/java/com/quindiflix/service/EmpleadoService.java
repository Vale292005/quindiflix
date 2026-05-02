package com.quindiflix.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quindiflix.dto.EmpleadoDTO;
import com.quindiflix.mapper.EmpleadoMapper;
import com.quindiflix.model.Empleado;
import com.quindiflix.model.Departamento;
import com.quindiflix.repository.DepartamentoRepository;
import com.quindiflix.repository.EmpleadoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService {

    private final EmpleadoRepository repository;
    private final EmpleadoMapper mapper;
    private final DepartamentoRepository departamentoRepository;
    private final EmpleadoRepository empleadoRepository;

    public EmpleadoService(EmpleadoRepository repository, EmpleadoMapper mapper, DepartamentoRepository departamentoRepository, EmpleadoRepository empleadoRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.departamentoRepository = departamentoRepository;
        this.empleadoRepository = empleadoRepository;
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
    public EmpleadoDTO save(EmpleadoDTO dto) {
        Empleado entidad = mapper.toEntity(dto);
        if(dto.getIdSupervisor() != null) {
            Empleado supervisor = empleadoRepository.findById(dto.getIdSupervisor())
                    .orElseThrow(() -> new RuntimeException("Supervisor no encontrado"));
            entidad.setSupervisor(supervisor);
        }
        if(dto.getIdDepartamento() != null) {
            Departamento departamento = departamentoRepository.findById(dto.getIdDepartamento())
                    .orElseThrow(() -> new RuntimeException("Departamento no encontrado"));
            entidad.setDepartamento(departamento);
        }
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
                    
                    if(dto.getIdSupervisor() != null) {
                        Empleado supervisor = repository.findById(dto.getIdSupervisor())
                                .orElseThrow(() -> new RuntimeException("Supervisor no encontrado"));
                        existente.setSupervisor(supervisor);
                    }
                    
                    if(dto.getIdDepartamento() != null) {
                        Departamento departamento = departamentoRepository.findById(dto.getIdDepartamento())
                                .orElseThrow(() -> new RuntimeException("Departamento no encontrado"));
                        existente.setDepartamento(departamento);
                    }
                    
                    return mapper.toDTO(repository.save(existente));
                })
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado"));
    }

    @Transactional
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}