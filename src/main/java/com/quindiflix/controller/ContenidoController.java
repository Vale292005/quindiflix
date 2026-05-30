package com.quindiflix.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.quindiflix.dto.ContenidoDTO;
import com.quindiflix.service.ContenidoService;

import java.util.List;

@RestController
@RequestMapping("/api/contenidos")
public class ContenidoController {

    private final ContenidoService service;

    public ContenidoController(ContenidoService service) {
        this.service = service;
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
}
