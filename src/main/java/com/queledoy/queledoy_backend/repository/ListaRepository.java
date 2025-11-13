package com.queledoy.queledoy_backend.repository;

import com.queledoy.queledoy_backend.model.Lista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ListaRepository extends JpaRepository<Lista, Integer> {
    Optional<Lista> findByNombre(String nombre);
}
