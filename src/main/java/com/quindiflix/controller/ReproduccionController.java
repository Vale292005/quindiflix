package com.quindiflix.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.quindiflix.dto.ReproduccionDTO;
import com.quindiflix.service.ReproduccionService;

import java.util.List;

@RestController
@RequestMapping("/api/reproducciones")
public class ReproduccionController {

    private final ReproduccionService service;

    public ReproduccionController(ReproduccionService service) {
        this.service = service;
    }

    @GetMapping
    public List<ReproduccionDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReproduccionDTO> findById(@PathVariable Integer id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ReproduccionDTO create(@RequestBody ReproduccionDTO dto) {
        return service.save(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReproduccionDTO> update(@PathVariable Integer id, @RequestBody ReproduccionDTO dto) {
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
