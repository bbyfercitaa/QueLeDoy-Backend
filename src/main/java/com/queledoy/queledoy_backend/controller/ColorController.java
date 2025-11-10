package com.queledoy.queledoy_backend.controller;

import com.queledoy.queledoy_backend.model.Color;
import com.queledoy.queledoy_backend.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/colores")
public class ColorController {

    @Autowired
    private ColorService colorService;

    @GetMapping
    public ResponseEntity<List<Color>> obtenerTodos() {
        List<Color> colores = colorService.obtenerTodos();
        return ResponseEntity.ok(colores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Color> obtenerPorId(@PathVariable Integer id) {
        Optional<Color> color = colorService.obtenerPorId(id);
        return color.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<Color> obtenerPorNombre(@PathVariable String nombre) {
        Optional<Color> color = colorService.obtenerPorNombre(nombre);
        return color.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Color> crear(@RequestBody Color color) {
        Color nuevoColor = colorService.guardar(color);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoColor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Color> actualizar(@PathVariable Integer id, @RequestBody Color color) {
        if (!colorService.existe(id)) {
            return ResponseEntity.notFound().build();
        }
        Color colorActualizado = colorService.actualizar(id, color);
        return ResponseEntity.ok(colorActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        if (!colorService.existe(id)) {
            return ResponseEntity.notFound().build();
        }
        colorService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
