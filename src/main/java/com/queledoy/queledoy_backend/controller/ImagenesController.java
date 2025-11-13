package com.queledoy.queledoy_backend.controller;

import com.queledoy.queledoy_backend.model.Imagenes;
import com.queledoy.queledoy_backend.service.ImagenesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/imagenesdet")
public class ImagenesController {

    @Autowired
    private ImagenesService imagenesService;

    @GetMapping
    public ResponseEntity<List<Imagenes>> obtenerTodas() {
        List<Imagenes> imagenes = imagenesService.obtenerTodas();
        return ResponseEntity.ok(imagenes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Imagenes> obtenerPorId(@PathVariable Integer id) {
        Optional<Imagenes> imagenes = imagenesService.obtenerPorId(id);
        return imagenes.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Imagenes> crear(@RequestBody Imagenes imagenes) {
        Imagenes nuevasImagenes = imagenesService.guardar(imagenes);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevasImagenes);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Imagenes> actualizar(@PathVariable Integer id, @RequestBody Imagenes imagenes) {
        if (!imagenesService.existe(id)) {
            return ResponseEntity.notFound().build();
        }
        Imagenes imagenesActualizada = imagenesService.actualizar(id, imagenes);
        return ResponseEntity.ok(imagenesActualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        if (!imagenesService.existe(id)) {
            return ResponseEntity.notFound().build();
        }
        imagenesService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
