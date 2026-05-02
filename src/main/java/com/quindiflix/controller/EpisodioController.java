package com.quindiflix.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.quindiflix.dto.EpisodioDTO;
import com.quindiflix.service.EpisodioService;

import java.util.List;

@RestController
@RequestMapping("/api/episodios")
public class EpisodioController {

    private final EpisodioService service;

    public EpisodioController(EpisodioService service) {
        this.service = service;
    }

    @GetMapping
    public List<EpisodioDTO> findAll() {
        return service.findAll().stream()
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EpisodioDTO> findById(@PathVariable Integer id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public EpisodioDTO create(@RequestBody EpisodioDTO dto) {
        return service.save(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EpisodioDTO> update(@PathVariable Integer id, @RequestBody EpisodioDTO dto) {
        return service.findById(id)
                .map(existing -> service.save(dto))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
