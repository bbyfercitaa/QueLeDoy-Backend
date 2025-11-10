package com.queledoy.queledoy_backend.repository;

import com.queledoy.queledoy_backend.model.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ColorRepository extends JpaRepository<Color, Integer> {
    Optional<Color> findByNombre(String nombre);
}
