package com.example.catalogliceu.repositories;

import com.example.catalogliceu.entities.AnClasa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnClasaRepository extends JpaRepository<AnClasa, Long> {
}
