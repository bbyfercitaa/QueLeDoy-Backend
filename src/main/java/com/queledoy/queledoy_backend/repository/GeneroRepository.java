package com.queledoy.queledoy_backend.repository;

import com.queledoy.queledoy_backend.model.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, Integer> {
    Optional<Genero> findByNombre(String nombre);
}
