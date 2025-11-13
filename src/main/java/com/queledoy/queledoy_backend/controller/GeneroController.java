package com.queledoy.queledoy_backend.controller;

import com.queledoy.queledoy_backend.model.Genero;
import com.queledoy.queledoy_backend.service.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/generos")
public class GeneroController {

    @Autowired
    private GeneroService generoService;

    @GetMapping
    public ResponseEntity<List<Genero>> obtenerTodos() {
        List<Genero> generos = generoService.obtenerTodos();
        return ResponseEntity.ok(generos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Genero> obtenerPorId(@PathVariable Integer id) {
        Optional<Genero> genero = generoService.obtenerPorId(id);
        return genero.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<Genero> obtenerPorNombre(@PathVariable String nombre) {
        Optional<Genero> genero = generoService.obtenerPorNombre(nombre);
        return genero.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Genero> crear(@RequestBody Genero genero) {
        Genero nuevoGenero = generoService.guardar(genero);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoGenero);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Genero> actualizar(@PathVariable Integer id, @RequestBody Genero genero) {
        if (!generoService.existe(id)) {
            return ResponseEntity.notFound().build();
        }
        Genero generoActualizado = generoService.actualizar(id, genero);
        return ResponseEntity.ok(generoActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        if (!generoService.existe(id)) {
            return ResponseEntity.notFound().build();
        }
        generoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
