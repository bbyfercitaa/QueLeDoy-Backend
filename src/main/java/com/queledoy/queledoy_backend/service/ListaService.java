package com.queledoy.queledoy_backend.service;

import com.queledoy.queledoy_backend.model.Lista;
import com.queledoy.queledoy_backend.repository.ListaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ListaService {

    @Autowired
    private ListaRepository listaRepository;

    public List<Lista> obtenerTodas() {
        return listaRepository.findAll();
    }

    public Optional<Lista> obtenerPorId(Integer id) {
        return listaRepository.findById(id);
    }

    public Optional<Lista> obtenerPorNombre(String nombre) {
        return listaRepository.findByNombre(nombre);
    }

    public Lista guardar(Lista lista) {
        return listaRepository.save(lista);
    }

    public Lista actualizar(Integer id, Lista lista) {
        lista.setId(id);
        return listaRepository.save(lista);
    }

    public void eliminar(Integer id) {
        listaRepository.deleteById(id);
    }

    public boolean existe(Integer id) {
        return listaRepository.existsById(id);
    }
}
