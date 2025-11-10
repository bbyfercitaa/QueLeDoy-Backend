package com.queledoy.queledoy_backend.service;

import com.queledoy.queledoy_backend.model.Color;
import com.queledoy.queledoy_backend.repository.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ColorService {

    @Autowired
    private ColorRepository colorRepository;

    public List<Color> obtenerTodos() {
        return colorRepository.findAll();
    }

    public Optional<Color> obtenerPorId(Integer id) {
        return colorRepository.findById(id);
    }

    public Optional<Color> obtenerPorNombre(String nombre) {
        return colorRepository.findByNombre(nombre);
    }

    public Color guardar(Color color) {
        return colorRepository.save(color);
    }

    public Color actualizar(Integer id, Color color) {
        color.setId(id);
        return colorRepository.save(color);
    }

    public void eliminar(Integer id) {
        colorRepository.deleteById(id);
    }

    public boolean existe(Integer id) {
        return colorRepository.existsById(id);
    }
}
