package com.queledoy.queledoy_backend.service;

import com.queledoy.queledoy_backend.model.Categorias;
import com.queledoy.queledoy_backend.repository.CategoriasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriasService {

    @Autowired
    private CategoriasRepository categoriasRepository;

    public List<Categorias> obtenerTodas() {
        return categoriasRepository.findAll();
    }

    public Optional<Categorias> obtenerPorId(Integer id) {
        return categoriasRepository.findById(id);
    }

    public Optional<Categorias> obtenerPorNombre(String nombre) {
        return categoriasRepository.findByNombre(nombre);
    }

    public Categorias guardar(Categorias categorias) {
        return categoriasRepository.save(categorias);
    }

    public Categorias actualizar(Integer id, Categorias categorias) {
        categorias.setId(id);
        return categoriasRepository.save(categorias);
    }

    public void eliminar(Integer id) {
        categoriasRepository.deleteById(id);
    }

    public boolean existe(Integer id) {
        return categoriasRepository.existsById(id);
    }
}
