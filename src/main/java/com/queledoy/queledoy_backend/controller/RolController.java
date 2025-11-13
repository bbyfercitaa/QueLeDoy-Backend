package com.queledoy.queledoy_backend.controller;

import com.queledoy.queledoy_backend.model.Rol;
import com.queledoy.queledoy_backend.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/roles")
public class RolController {

    @Autowired
    private RolService rolService;

    @GetMapping
    public ResponseEntity<List<Rol>> obtenerTodos() {
        List<Rol> roles = rolService.obtenerTodos();
        return ResponseEntity.ok(roles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rol> obtenerPorId(@PathVariable Integer id) {
        Optional<Rol> rol = rolService.obtenerPorId(id);
        return rol.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<Rol> obtenerPorNombre(@PathVariable String nombre) {
        Optional<Rol> rol = rolService.obtenerPorNombre(nombre);
        return rol.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Rol> crear(@RequestBody Rol rol) {
        Rol nuevoRol = rolService.guardar(rol);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoRol);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rol> actualizar(@PathVariable Integer id, @RequestBody Rol rol) {
        if (!rolService.existe(id)) {
            return ResponseEntity.notFound().build();
        }
        Rol rolActualizado = rolService.actualizar(id, rol);
        return ResponseEntity.ok(rolActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        if (!rolService.existe(id)) {
            return ResponseEntity.notFound().build();
        }
        rolService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
