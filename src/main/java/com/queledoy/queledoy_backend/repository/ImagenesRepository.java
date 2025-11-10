package com.queledoy.queledoy_backend.repository;

import com.queledoy.queledoy_backend.model.Imagenes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImagenesRepository extends JpaRepository<Imagenes, Integer> {
}
