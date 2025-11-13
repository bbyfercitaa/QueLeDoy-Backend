package com.queledoy.queledoy_backend.controller;

import com.queledoy.queledoy_backend.model.Colores;
import com.queledoy.queledoy_backend.service.ColoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/coloresdet")
public class ColoresController {

    @Autowired
    private ColoresService coloresService;

    @GetMapping
    public ResponseEntity<List<Colores>> obtenerTodos() {
        List<Colores> colores = coloresService.obtenerTodos();
        return ResponseEntity.ok(colores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Colores> obtenerPorId(@PathVariable Integer id) {
        Optional<Colores> colores = coloresService.obtenerPorId(id);
        return colores.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<Colores> obtenerPorNombre(@PathVariable String nombre) {
        Optional<Colores> colores = coloresService.obtenerPorNombre(nombre);
        return colores.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Colores> crear(@RequestBody Colores colores) {
        Colores nuevoColores = coloresService.guardar(colores);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoColores);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Colores> actualizar(@PathVariable Integer id, @RequestBody Colores colores) {
        if (!coloresService.existe(id)) {
            return ResponseEntity.notFound().build();
        }
        Colores coloresActualizado = coloresService.actualizar(id, colores);
        return ResponseEntity.ok(coloresActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        if (!coloresService.existe(id)) {
            return ResponseEntity.notFound().build();
        }
        coloresService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
