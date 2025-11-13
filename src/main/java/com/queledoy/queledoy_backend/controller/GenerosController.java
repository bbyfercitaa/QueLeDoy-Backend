package com.queledoy.queledoy_backend.controller;

import com.queledoy.queledoy_backend.model.Generos;
import com.queledoy.queledoy_backend.service.GenerosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/generosdet")
public class GenerosController {

    @Autowired
    private GenerosService generosService;

    @GetMapping
    public ResponseEntity<List<Generos>> obtenerTodos() {
        List<Generos> generos = generosService.obtenerTodos();
        return ResponseEntity.ok(generos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Generos> obtenerPorId(@PathVariable Integer id) {
        Optional<Generos> generos = generosService.obtenerPorId(id);
        return generos.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<Generos> obtenerPorNombre(@PathVariable String nombre) {
        Optional<Generos> generos = generosService.obtenerPorNombre(nombre);
        return generos.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Generos> crear(@RequestBody Generos generos) {
        Generos nuevoGeneros = generosService.guardar(generos);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoGeneros);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Generos> actualizar(@PathVariable Integer id, @RequestBody Generos generos) {
        if (!generosService.existe(id)) {
            return ResponseEntity.notFound().build();
        }
        Generos generosActualizado = generosService.actualizar(id, generos);
        return ResponseEntity.ok(generosActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        if (!generosService.existe(id)) {
            return ResponseEntity.notFound().build();
        }
        generosService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
