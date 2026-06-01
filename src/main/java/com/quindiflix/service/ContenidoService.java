package com.quindiflix.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import com.quindiflix.dto.ContenidoDTO;
import com.quindiflix.dto.TopContenidoProjection;
import com.quindiflix.exception.BadRequestException;
import com.quindiflix.mapper.ContenidoMapper;
import com.quindiflix.model.Contenido;
import com.quindiflix.model.Departamento;
import com.quindiflix.model.Empleado;
import com.quindiflix.model.Perfil;
import com.quindiflix.model.Categoria;
import com.quindiflix.repository.ContenidoRepository;
import com.quindiflix.repository.EmpleadoRepository;
import com.quindiflix.repository.PerfilRepository;
import com.quindiflix.repository.CategoriaRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContenidoService {

    private final ContenidoRepository repository;
    private final ContenidoMapper mapper;
    private final PerfilRepository perfilRepository;
    private final EmpleadoRepository empleadoRepository;
    private final CategoriaRepository categoriaRepository;

    public ContenidoService(ContenidoRepository repository,
            ContenidoMapper mapper,
            PerfilRepository perfilRepository,
            EmpleadoRepository empleadoRepository,
            CategoriaRepository categoriaRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.perfilRepository = perfilRepository;
        this.empleadoRepository = empleadoRepository;
        this.categoriaRepository = categoriaRepository;
    }

    public List<ContenidoDTO> findAll() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .toList();
    }

    public List<ContenidoDTO> findAllByPerfil(Integer idPerfil) {
        Perfil perfil = perfilRepository.findById(idPerfil)
                .orElseThrow(() -> new RuntimeException("Perfil no encontrado"));
        List<Contenido> resultados;
        if ("INFANTIL".equalsIgnoreCase(perfil.getTipoPerfil())) {
            List<String> clasificacionesPermitidas = Arrays.asList("TP", "+7", "+13");
            resultados = repository.findByTipoContenidoIn(clasificacionesPermitidas);
        } else {
            resultados = repository.findAll();
        }

        return resultados.stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<ContenidoDTO> findById(Integer id) {
        return repository.findById(id).map(mapper::toDTO);
    }

    // ContenidoService: Al guardar (save), debes setear automáticamente la fecha de
    // incorporación si viene nula:
    // contenido.setFechaIncorporacion(LocalDate.now()).
    @Transactional
    public ContenidoDTO save(ContenidoDTO dto) {
        Contenido entity = mapper.toEntity(dto);
        if (entity.getFechaIncorporacion() == null) {
            entity.setFechaIncorporacion(java.time.LocalDate.now());
        }
        if (entity.getEmpleado() != null) {
            Departamento departamento = entity.getEmpleado().getDepartamento();
            if (!"Departamento de Contenidos".equals(departamento.getNombre())) {
                throw new BadRequestException("El empleado responsable debe pertenecer al Departamento de Contenidos");
            }
        } else {
            throw new BadRequestException("Debe asignar un empleado responsable al contenido.");
        }
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

                    if (existente.getFechaIncorporacion() == null) {
                        existente.setFechaIncorporacion(java.time.LocalDate.now());
                    }

                    // Actualizamos relaciones
                    vincularRelaciones(existente, dto);
                    if (existente.getEmpleado() != null) {
                        Departamento departamento = existente.getEmpleado().getDepartamento();
                        if (!"Departamento de Contenidos".equals(departamento.getNombre())) {
                            throw new BadRequestException(
                                    "El empleado responsable debe pertenecer al Departamento de Contenidos");
                        }
                    } else {
                        throw new BadRequestException("Debe asignar un empleado responsable al contenido.");
                    }

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

    public List<TopContenidoProjection> getTop10ByCiudad(String param) {
        if (param == null || param.trim().isEmpty()) {
            throw new IllegalArgumentException("El parámetro 'ciudad' no puede ser nulo o vacío");
        }
        return repository.findTop10ByCiudad(param.trim());
    }
}