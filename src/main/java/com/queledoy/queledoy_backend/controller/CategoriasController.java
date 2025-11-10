package com.queledoy.queledoy_backend.controller;

import com.queledoy.queledoy_backend.model.Categorias;
import com.queledoy.queledoy_backend.service.CategoriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categoriasdet")
public class CategoriasController {

    @Autowired
    private CategoriasService categoriasService;

    @GetMapping
    public ResponseEntity<List<Categorias>> obtenerTodas() {
        List<Categorias> categorias = categoriasService.obtenerTodas();
        return ResponseEntity.ok(categorias);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categorias> obtenerPorId(@PathVariable Integer id) {
        Optional<Categorias> categorias = categoriasService.obtenerPorId(id);
        return categorias.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<Categorias> obtenerPorNombre(@PathVariable String nombre) {
        Optional<Categorias> categorias = categoriasService.obtenerPorNombre(nombre);
        return categorias.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Categorias> crear(@RequestBody Categorias categorias) {
        Categorias nuevaCategorias = categoriasService.guardar(categorias);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaCategorias);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categorias> actualizar(@PathVariable Integer id, @RequestBody Categorias categorias) {
        if (!categoriasService.existe(id)) {
            return ResponseEntity.notFound().build();
        }
        Categorias categoriasActualizada = categoriasService.actualizar(id, categorias);
        return ResponseEntity.ok(categoriasActualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        if (!categoriasService.existe(id)) {
            return ResponseEntity.notFound().build();
        }
        categoriasService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
