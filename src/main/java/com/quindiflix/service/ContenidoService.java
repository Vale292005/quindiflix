package com.quindiflix.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quindiflix.dto.ContenidoDTO;
import com.quindiflix.mapper.ContenidoMapper;
import com.quindiflix.model.Contenido;
import com.quindiflix.model.Empleado;
import com.quindiflix.model.Categoria;
import com.quindiflix.repository.ContenidoRepository;
import com.quindiflix.repository.EmpleadoRepository;
import com.quindiflix.repository.CategoriaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ContenidoService {

    private final ContenidoRepository repository;
    private final ContenidoMapper mapper;
    // Agregamos los repositorios para las relaciones
    private final EmpleadoRepository empleadoRepository;
    private final CategoriaRepository categoriaRepository;

    public ContenidoService(ContenidoRepository repository, 
                            ContenidoMapper mapper, 
                            EmpleadoRepository empleadoRepository,
                            CategoriaRepository categoriaRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.empleadoRepository = empleadoRepository;
        this.categoriaRepository = categoriaRepository;
    }

    public List<ContenidoDTO> findAll() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .toList();
    }

    public Optional<ContenidoDTO> findById(Integer id) {
        return repository.findById(id).map(mapper::toDTO);
    }

    @Transactional
    public ContenidoDTO save(ContenidoDTO dto) {
        Contenido entity = mapper.toEntity(dto);
        
        // Asignamos relaciones antes de guardar
        vincularRelaciones(entity, dto);
        
        return mapper.toDTO(repository.save(entity));
    }

    @Transactional
    public ContenidoDTO update(Integer id, ContenidoDTO dto) {
        return repository.findById(id)
                .map(existente -> {
                    existente.setTitulo(dto.getTitulo());
                    existente.setFechaIncorporacion(dto.getFechaIncorporacion());
                    existente.setTipoContenido(dto.getTipoContenido());
                    existente.setEsOriginal(dto.getEsOriginal());
                    
                    // Actualizamos relaciones
                    vincularRelaciones(existente, dto);
                    
                    return mapper.toDTO(repository.save(existente));
                })
                .orElseThrow(() -> new RuntimeException("Contenido no encontrado"));
    }

    @Transactional
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    // Método privado para no repetir la lógica en save y update
    private void vincularRelaciones(Contenido entity, ContenidoDTO dto) {
        if (dto.getIdEmpleadoResponsable() != null) {
            Empleado empleado = empleadoRepository.findById(dto.getIdEmpleadoResponsable())
                    .orElseThrow(() -> new RuntimeException("Empleado responsable no encontrado"));
            entity.setEmpleado(empleado);
        }

        if (dto.getIdCategoria() != null) {
            Categoria categoria = categoriaRepository.findById(dto.getIdCategoria())
                    .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));
            entity.setCategoria(categoria);
        }
    }
}