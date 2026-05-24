package com.quindiflix.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.quindiflix.dto.EmpleadoDTO;
import com.quindiflix.dto.RegistroEmpleadoRequest;
import com.quindiflix.service.EmpleadoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {

    private final EmpleadoService service;

    public EmpleadoController(EmpleadoService service) {
        this.service = service;
    }

    @GetMapping
    public List<EmpleadoDTO> findAll() {
        return service.findAll().stream()
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpleadoDTO> findById(@PathVariable Integer id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmpleadoDTO create(@RequestBody EmpleadoDTO.Registro dto) { // 👈 Cambiado aquí
        return service.save(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmpleadoDTO> update(@PathVariable Integer id, @RequestBody EmpleadoDTO dto) {
        try {
            EmpleadoDTO actualizado = service.update(id, dto);
            return ResponseEntity.ok(actualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/registrar")
    public ResponseEntity<EmpleadoDTO> registrar(@RequestBody RegistroEmpleadoRequest request) {
        return ResponseEntity.ok(service.registrarEmpleado(request.getDatosEmpleado(), request.getPassword()));
    }
}
