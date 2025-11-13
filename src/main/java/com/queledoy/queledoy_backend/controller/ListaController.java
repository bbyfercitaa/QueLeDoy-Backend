package com.queledoy.queledoy_backend.controller;

import com.queledoy.queledoy_backend.model.Lista;
import com.queledoy.queledoy_backend.service.ListaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/listas")
public class ListaController {

    @Autowired
    private ListaService listaService;

    @GetMapping
    public ResponseEntity<List<Lista>> obtenerTodas() {
        List<Lista> listas = listaService.obtenerTodas();
        return ResponseEntity.ok(listas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lista> obtenerPorId(@PathVariable Integer id) {
        Optional<Lista> lista = listaService.obtenerPorId(id);
        return lista.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<Lista> obtenerPorNombre(@PathVariable String nombre) {
        Optional<Lista> lista = listaService.obtenerPorNombre(nombre);
        return lista.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Lista> crear(@RequestBody Lista lista) {
        Lista nuevaLista = listaService.guardar(lista);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaLista);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Lista> actualizar(@PathVariable Integer id, @RequestBody Lista lista) {
        if (!listaService.existe(id)) {
            return ResponseEntity.notFound().build();
        }
        Lista listaActualizada = listaService.actualizar(id, lista);
        return ResponseEntity.ok(listaActualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        if (!listaService.existe(id)) {
            return ResponseEntity.notFound().build();
        }
        listaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
