package com.queledoy.queledoy_backend.repository;

import com.queledoy.queledoy_backend.model.Generos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GenerosRepository extends JpaRepository<Generos, Integer> {
    Optional<Generos> findByNombre(String nombre);
}
