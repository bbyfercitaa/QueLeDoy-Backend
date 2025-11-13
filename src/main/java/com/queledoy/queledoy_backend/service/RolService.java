package com.queledoy.queledoy_backend.service;

import com.queledoy.queledoy_backend.model.Rol;
import com.queledoy.queledoy_backend.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RolService {

    @Autowired
    private RolRepository rolRepository;

    public List<Rol> obtenerTodos() {
        return rolRepository.findAll();
    }

    public Optional<Rol> obtenerPorId(Integer id) {
        return rolRepository.findById(id);
    }

    public Optional<Rol> obtenerPorNombre(String nombre) {
        return rolRepository.findByNombre(nombre);
    }

    public Rol guardar(Rol rol) {
        return rolRepository.save(rol);
    }

    public Rol actualizar(Integer id, Rol rol) {
        rol.setId(id);
        return rolRepository.save(rol);
    }

    public void eliminar(Integer id) {
        rolRepository.deleteById(id);
    }

    public boolean existe(Integer id) {
        return rolRepository.existsById(id);
    }
}
