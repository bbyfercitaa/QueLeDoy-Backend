package com.queledoy.queledoy_backend.service;

import com.queledoy.queledoy_backend.model.Producto;
import com.queledoy.queledoy_backend.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> obtenerTodos() {
        return productoRepository.findAll();
    }

    public Optional<Producto> obtenerPorId(Integer id) {
        return productoRepository.findById(id);
    }

    public List<Producto> obtenerPorActivo(Boolean activo) {
        return productoRepository.findByActivo(activo);
    }

    public List<Producto> obtenerPorDestacado(Boolean destacado) {
        return productoRepository.findByDestacado(destacado);
    }

    public Producto guardar(Producto producto) {
        return productoRepository.save(producto);
    }

    public Producto actualizar(Integer id, Producto producto) {
        producto.setId(id);
        return productoRepository.save(producto);
    }

    public void eliminar(Integer id) {
        productoRepository.deleteById(id);
    }

    public boolean existe(Integer id) {
        return productoRepository.existsById(id);
    }

    public List<Producto> obtenerProductosDisponibles() {
        return productoRepository.findByActivo(true);
    }

    public List<Producto> obtenerProductosDestacados() {
        return productoRepository.findByDestacado(true);
    }
}
