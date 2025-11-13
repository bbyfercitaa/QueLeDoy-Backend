package com.queledoy.queledoy_backend.service;

import com.queledoy.queledoy_backend.model.Imagenes;
import com.queledoy.queledoy_backend.repository.ImagenesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ImagenesService {

    @Autowired
    private ImagenesRepository imagenesRepository;

    public List<Imagenes> obtenerTodas() {
        return imagenesRepository.findAll();
    }

    public Optional<Imagenes> obtenerPorId(Integer id) {
        return imagenesRepository.findById(id);
    }

    public Imagenes guardar(Imagenes imagenes) {
        return imagenesRepository.save(imagenes);
    }

    public Imagenes actualizar(Integer id, Imagenes imagenes) {
        imagenes.setId(id);
        return imagenesRepository.save(imagenes);
    }

    public void eliminar(Integer id) {
        imagenesRepository.deleteById(id);
    }

    public boolean existe(Integer id) {
        return imagenesRepository.existsById(id);
    }
}
