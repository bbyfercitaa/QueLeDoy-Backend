package com.queledoy.queledoy_backend.service;

import com.queledoy.queledoy_backend.model.Colores;
import com.queledoy.queledoy_backend.repository.ColoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ColoresService {

    @Autowired
    private ColoresRepository coloresRepository;

    public List<Colores> obtenerTodos() {
        return coloresRepository.findAll();
    }

    public Optional<Colores> obtenerPorId(Integer id) {
        return coloresRepository.findById(id);
    }

    public Optional<Colores> obtenerPorNombre(String nombre) {
        return coloresRepository.findByNombre(nombre);
    }

    public Colores guardar(Colores colores) {
        return coloresRepository.save(colores);
    }

    public Colores actualizar(Integer id, Colores colores) {
        colores.setId(id);
        return coloresRepository.save(colores);
    }

    public void eliminar(Integer id) {
        coloresRepository.deleteById(id);
    }

    public boolean existe(Integer id) {
        return coloresRepository.existsById(id);
    }
}
