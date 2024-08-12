package com.example.catalogliceu.repositories;

import com.example.catalogliceu.entities.AdministratorScolar;
import com.example.catalogliceu.entities.Liceu;
import com.example.catalogliceu.entities.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, Long> {
    Optional<Profesor> findByPorecla(String porecla);
}
