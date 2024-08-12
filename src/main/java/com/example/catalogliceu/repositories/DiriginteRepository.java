package com.example.catalogliceu.repositories;

import com.example.catalogliceu.entities.Clasa;
import com.example.catalogliceu.entities.Diriginte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DiriginteRepository extends JpaRepository<Diriginte, Long> {
    Optional<Diriginte> findByClasa(Clasa clasa);
}
