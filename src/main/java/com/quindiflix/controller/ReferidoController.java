package com.quindiflix.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.quindiflix.dto.ReferidoDTO;
import com.quindiflix.service.ReferidoService;

import java.util.List;

@RestController
@RequestMapping("/api/referidos")
public class ReferidoController {

    private final ReferidoService service;

    public ReferidoController(ReferidoService service) {
        this.service = service;
    }

    @GetMapping
    public List<ReferidoDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReferidoDTO> findById(@PathVariable Integer id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ReferidoDTO create(@RequestBody ReferidoDTO dto) {
        return service.save(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReferidoDTO> update(@PathVariable Integer id, @RequestBody ReferidoDTO dto) {
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
