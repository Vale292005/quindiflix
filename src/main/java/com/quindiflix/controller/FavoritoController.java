package com.quindiflix.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.quindiflix.dto.FavoritoContenidoDTO;
import com.quindiflix.dto.FavoritoDTO;
import com.quindiflix.repository.FavoritoRepository;
import com.quindiflix.service.FavoritoService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/favoritos")
public class FavoritoController {

    private final FavoritoService service;
    private final FavoritoRepository favoritoRepository;

    public FavoritoController(FavoritoService service, FavoritoRepository favoritoRepository) {
        this.service = service;
        this.favoritoRepository = favoritoRepository;
    }

    @PostMapping("/agregar")
    public ResponseEntity<?> agregarFavorito(@RequestBody Map<String, Object> payload) {
        Integer idPerfil = ((Number) payload.get("idPerfil")).intValue();
        Integer idContenido = ((Number) payload.get("idContenido")).intValue();

        favoritoRepository.agregarFavoritoPL(idPerfil, idContenido);
        return ResponseEntity.ok().body(Map.of("message", "Agregado con éxito"));
    }

    // 2. Endpoint para Eliminar
    @DeleteMapping("/eliminar/perfil/{idPerfil}/contenido/{idContenido}")
    public ResponseEntity<?> eliminarFavorito(@PathVariable Integer idPerfil, @PathVariable Integer idContenido) {
        favoritoRepository.eliminarFavoritoPL(idPerfil, idContenido);
        return ResponseEntity.ok().body(Map.of("message", "Eliminado con éxito"));
    }

    // 3. Endpoint para Comprobar
    @GetMapping("/comprobar/perfil/{idPerfil}/contenido/{idContenido}")
    public ResponseEntity<Boolean> esFavorito(@PathVariable Integer idPerfil, @PathVariable Integer idContenido) {
        Integer conteo = favoritoRepository.comprobarFavoritoNativo(idPerfil, idContenido);
        boolean existe = conteo > 0;
        return ResponseEntity.ok(existe);
    }

    @GetMapping
    public List<FavoritoDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FavoritoDTO> findById(@PathVariable Integer id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

@GetMapping("/perfil/{idPerfil}")
    public ResponseEntity<List<FavoritoContenidoDTO>> getFavoritosByPerfil(@PathVariable Integer idPerfil) {
        List<Object[]> resultados = favoritoRepository.buscarContenidosFavoritosPorPerfil(idPerfil);
        List<FavoritoContenidoDTO> listaFavoritos = new ArrayList<>();

        for (Object[] row : resultados) {
            FavoritoContenidoDTO dto = FavoritoContenidoDTO.builder()
                .idContenido(row[0] != null ? ((Number) row[0]).intValue() : null)
                .titulo(row[1] != null ? row[1].toString() : null)
                .tipoContenido(row[2] != null ? row[2].toString() : null)
                .esOriginal(row[3] != null ? ((Number) row[3]).intValue() == 1 : false)
                .urlImagen(row[4] != null ? row[4].toString() : null)
                .build();
            
            listaFavoritos.add(dto);
        }

        return ResponseEntity.ok(listaFavoritos);
    }

    @PostMapping
    public FavoritoDTO create(@RequestBody FavoritoDTO dto) {
        return service.save(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FavoritoDTO> update(@PathVariable Integer id, @RequestBody FavoritoDTO dto) {
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
