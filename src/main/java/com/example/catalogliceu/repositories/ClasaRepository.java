package com.example.catalogliceu.repositories;

import com.example.catalogliceu.entities.Clasa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClasaRepository extends JpaRepository<Clasa, Long> {
}
