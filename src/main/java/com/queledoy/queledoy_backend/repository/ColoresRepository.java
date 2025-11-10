package com.queledoy.queledoy_backend.repository;

import com.queledoy.queledoy_backend.model.Colores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ColoresRepository extends JpaRepository<Colores, Integer> {
    Optional<Colores> findByNombre(String nombre);
}
