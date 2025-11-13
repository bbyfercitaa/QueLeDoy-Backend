package com.queledoy.queledoy_backend.controller;

import com.queledoy.queledoy_backend.model.Imagen;
import com.queledoy.queledoy_backend.service.ImagenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/imagenes")
public class ImagenController {

    @Autowired
    private ImagenService imagenService;

    @GetMapping
    public ResponseEntity<List<Imagen>> obtenerTodas() {
        List<Imagen> imagenes = imagenService.obtenerTodas();
        return ResponseEntity.ok(imagenes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Imagen> obtenerPorId(@PathVariable Integer id) {
        Optional<Imagen> imagen = imagenService.obtenerPorId(id);
        return imagen.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Imagen> crear(@RequestBody Imagen imagen) {
        Imagen nuevaImagen = imagenService.guardar(imagen);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaImagen);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Imagen> actualizar(@PathVariable Integer id, @RequestBody Imagen imagen) {
        if (!imagenService.existe(id)) {
            return ResponseEntity.notFound().build();
        }
        Imagen imagenActualizada = imagenService.actualizar(id, imagen);
        return ResponseEntity.ok(imagenActualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        if (!imagenService.existe(id)) {
            return ResponseEntity.notFound().build();
        }
        imagenService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
