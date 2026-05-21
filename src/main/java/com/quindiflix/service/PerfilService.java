package com.quindiflix.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quindiflix.dto.PerfilDTO;
import com.quindiflix.exception.BadRequestException;
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

                long perfilesActuales=repository.countByCuenta_IdCuenta(dto.getIdCuenta());
                int limitePerfiles = cuenta.getPlan().getCantidadPantallas();
                if(perfilesActuales >= limitePerfiles) {
                    throw new BadRequestException("El número de perfiles para esta cuenta ha alcanzado el límite permitido por el plan.");
                }

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

    public List<PerfilDTO> findByCuentaId(Integer idCuenta) {
    // Si usas el mapeo plano nativo que hicimos para saltar el error de Oracle:
    List<Object[]> resultados = repository.buscarPerfilesPorCuentaNativo(idCuenta);
    
    return resultados.stream().map(row -> {
        PerfilDTO dto = new PerfilDTO();
        dto.setIdPerfil(row[0] != null ? ((Number) row[0]).intValue() : null);
        dto.setIdCuenta(row[1] != null ? ((Number) row[1]).intValue() : null);
        dto.setNombre(row[2] != null ? row[2].toString() : null);
        dto.setAvatar(row[3] != null ? row[3].toString() : null);
        dto.setTipoPerfil(row[4] != null ? row[4].toString() : null);
        return dto;
    }).toList();
}
}