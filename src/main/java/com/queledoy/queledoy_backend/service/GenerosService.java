package com.queledoy.queledoy_backend.service;

import com.queledoy.queledoy_backend.model.Generos;
import com.queledoy.queledoy_backend.repository.GenerosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class GenerosService {

    @Autowired
    private GenerosRepository generosRepository;

    public List<Generos> obtenerTodos() {
        return generosRepository.findAll();
    }

    public Optional<Generos> obtenerPorId(Integer id) {
        return generosRepository.findById(id);
    }

    public Optional<Generos> obtenerPorNombre(String nombre) {
        return generosRepository.findByNombre(nombre);
    }

    public Generos guardar(Generos generos) {
        return generosRepository.save(generos);
    }

    public Generos actualizar(Integer id, Generos generos) {
        generos.setId(id);
        return generosRepository.save(generos);
    }

    public void eliminar(Integer id) {
        generosRepository.deleteById(id);
    }

    public boolean existe(Integer id) {
        return generosRepository.existsById(id);
    }
}
