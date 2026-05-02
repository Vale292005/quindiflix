package com.quindiflix.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.quindiflix.dto.TemporadaDTO;
import com.quindiflix.exception.BadRequestException;
import com.quindiflix.service.TemporadaService;

import java.util.List;

@RestController
@RequestMapping("/api/temporadas")
public class TemporadaController {

    private final TemporadaService service;

    public TemporadaController(TemporadaService service) {
        this.service = service;
    }

    @GetMapping
    public List<TemporadaDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TemporadaDTO> findById(@PathVariable Integer id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TemporadaDTO> create(@RequestBody TemporadaDTO dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TemporadaDTO> update(@PathVariable Integer id, @RequestBody TemporadaDTO dto) {
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