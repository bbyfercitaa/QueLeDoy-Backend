package com.queledoy.queledoy_backend.repository;

import com.queledoy.queledoy_backend.model.Imagen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImagenRepository extends JpaRepository<Imagen, Integer> {
}
