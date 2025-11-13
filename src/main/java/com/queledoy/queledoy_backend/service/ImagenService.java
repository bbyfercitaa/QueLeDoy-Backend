package com.queledoy.queledoy_backend.service;

import com.queledoy.queledoy_backend.model.Imagen;
import com.queledoy.queledoy_backend.repository.ImagenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ImagenService {

    @Autowired
    private ImagenRepository imagenRepository;

    public List<Imagen> obtenerTodas() {
        return imagenRepository.findAll();
    }

    public Optional<Imagen> obtenerPorId(Integer id) {
        return imagenRepository.findById(id);
    }

    public Imagen guardar(Imagen imagen) {
        return imagenRepository.save(imagen);
    }

    public Imagen actualizar(Integer id, Imagen imagen) {
        imagen.setId(id);
        return imagenRepository.save(imagen);
    }

    public void eliminar(Integer id) {
        imagenRepository.deleteById(id);
    }

    public boolean existe(Integer id) {
        return imagenRepository.existsById(id);
    }
}
