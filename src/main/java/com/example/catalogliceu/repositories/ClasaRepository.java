package com.example.catalogliceu.repositories;

import com.example.catalogliceu.entities.Clasa;
import com.example.catalogliceu.entities.Liceu;
import com.example.catalogliceu.entities.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClasaRepository extends JpaRepository<Clasa, Long> {
    List<Clasa> findByLiceu(Liceu liceu);
}
