package com.quindiflix.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.quindiflix.dto.TemporadaDTO;
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
    public TemporadaDTO create(@RequestBody TemporadaDTO dto) {
        return service.save(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TemporadaDTO> update(@PathVariable Integer id, @RequestBody TemporadaDTO dto) {
        return service.findById(id)
                .map(existing -> ResponseEntity.ok(service.save(dto)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
