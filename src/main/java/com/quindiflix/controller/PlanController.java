package com.quindiflix.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.quindiflix.dto.PlanDTO;
import com.quindiflix.dto.PlanTransaccionesProjection;
import com.quindiflix.service.PlanService;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/planes")
public class PlanController {

    private final PlanService service;

    public PlanController(PlanService service) {
        this.service = service;
    }

    @GetMapping
    public List<PlanDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlanDTO> findById(@PathVariable Integer id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public PlanDTO create(@RequestBody PlanDTO dto) {
        return service.save(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlanDTO> update(@PathVariable Integer id, @RequestBody PlanDTO dto) {
        return service.findById(id)
                .map(existing -> ResponseEntity.ok(service.save(dto)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/ingresos-plan")
    public ResponseEntity<?> getIngresosPorPlan(@RequestParam(name = "mes") int mes, @RequestParam(name = "anio") int anio) {
        try {
            List<PlanTransaccionesProjection> resultados = service.getTransaccionesProjections(mes, anio);
            return ResponseEntity.ok(resultados);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
}
