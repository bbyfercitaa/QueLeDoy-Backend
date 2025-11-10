package com.queledoy.queledoy_backend.repository;

import com.queledoy.queledoy_backend.model.Categorias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoriasRepository extends JpaRepository<Categorias, Integer> {
    Optional<Categorias> findByNombre(String nombre);
}
