package com.quindiflix.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.quindiflix.dto.PerfilDTO;
import com.quindiflix.exception.BadRequestException;
import com.quindiflix.service.PerfilService;

import java.util.List;

@RestController
@RequestMapping("/api/perfiles")
public class PerfilController {

    private final PerfilService service;

    public PerfilController(PerfilService service) {
        this.service = service;
    }

    @GetMapping
    public List<PerfilDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PerfilDTO> findById(@PathVariable Integer id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/cuenta/{idCuenta}")
    public ResponseEntity<List<PerfilDTO>> findByCuentaId(@PathVariable Integer idCuenta) {
        List<PerfilDTO> perfiles = service.findByCuentaId(idCuenta);
        
        if (perfiles.isEmpty()) {
            return ResponseEntity.notFound().build(); // Devuelve 404 si la cuenta no tiene perfiles
        }
        
        return ResponseEntity.ok(perfiles); // Devuelve la lista con un 200 OK
    }

    @PostMapping
    public ResponseEntity<PerfilDTO> create(@RequestBody PerfilDTO dto) {
        return ResponseEntity.ok(service.save(dto));
    }

@PutMapping("/{id}")
    public ResponseEntity<PerfilDTO> update(@PathVariable Integer id, @RequestBody PerfilDTO dto) {
        try {
            return ResponseEntity.ok(service.update(id, dto));
        } catch (BadRequestException e) {
            return ResponseEntity.badRequest().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
