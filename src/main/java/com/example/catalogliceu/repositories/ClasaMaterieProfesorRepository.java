package com.example.catalogliceu.repositories;

import com.example.catalogliceu.entities.ClasaMaterieProfesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClasaMaterieProfesorRepository extends JpaRepository<ClasaMaterieProfesor, Long> {
}
