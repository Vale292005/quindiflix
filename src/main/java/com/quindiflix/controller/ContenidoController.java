package com.quindiflix.controller;

import com.quindiflix.repository.ContenidoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.quindiflix.dto.ContenidoDTO;
import com.quindiflix.dto.TopContenidoProjection;
import com.quindiflix.service.ContenidoService;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/contenidos")
public class ContenidoController {

    private final ContenidoRepository contenidoRepository;
    private final ContenidoService service;

    public ContenidoController(ContenidoService service, ContenidoRepository contenidoRepository) {
        this.service = service;
        this.contenidoRepository = contenidoRepository;
    }

    @GetMapping
    public List<ContenidoDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContenidoDTO> findById(@PathVariable Integer id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @PreAuthorize("authentication.principal.idDepartamento == 2")
    public ContenidoDTO create(@RequestBody ContenidoDTO dto) {
        return service.save(dto);
    }

    @PutMapping("/{id}")
    @PreAuthorize("authentication.principal.idDepartamento == 2")
    public ResponseEntity<ContenidoDTO> update(@PathVariable Integer id, @RequestBody ContenidoDTO dto) {
        try {
            return ResponseEntity.ok(service.update(id, dto));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("authentication.principal.idDepartamento == 2")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/perfil/{idPerfil}")
    public ResponseEntity<List<ContenidoDTO>> findAllByPerfil(@PathVariable Integer idPerfil) {
        return ResponseEntity.ok(service.findAllByPerfil(idPerfil));
    }

    @GetMapping("/top-contenido")
    public ResponseEntity<?> findTop10ByCiudad(@RequestParam("ciudad") String ciudad) {
        try {
            List<TopContenidoProjection> resultados = service.getTop10ByCiudad(ciudad);
            return ResponseEntity.ok(resultados);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
