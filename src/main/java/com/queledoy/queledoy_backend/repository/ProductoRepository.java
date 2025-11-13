package com.queledoy.queledoy_backend.repository;

import com.queledoy.queledoy_backend.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    List<Producto> findByActivo(Boolean activo);
    List<Producto> findByDestacado(Boolean destacado);
    List<Producto> findByCategorias(com.queledoy.queledoy_backend.model.Categorias categorias);
}
