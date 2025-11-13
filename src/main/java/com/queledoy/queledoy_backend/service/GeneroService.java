package com.queledoy.queledoy_backend.service;

import com.queledoy.queledoy_backend.model.Genero;
import com.queledoy.queledoy_backend.repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class GeneroService {

    @Autowired
    private GeneroRepository generoRepository;

    public List<Genero> obtenerTodos() {
        return generoRepository.findAll();
    }

    public Optional<Genero> obtenerPorId(Integer id) {
        return generoRepository.findById(id);
    }

    public Optional<Genero> obtenerPorNombre(String nombre) {
        return generoRepository.findByNombre(nombre);
    }

    public Genero guardar(Genero genero) {
        return generoRepository.save(genero);
    }

    public Genero actualizar(Integer id, Genero genero) {
        genero.setId(id);
        return generoRepository.save(genero);
    }

    public void eliminar(Integer id) {
        generoRepository.deleteById(id);
    }

    public boolean existe(Integer id) {
        return generoRepository.existsById(id);
    }
}
