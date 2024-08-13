package com.example.catalogliceu.repositories;

import com.example.catalogliceu.entities.Clasa;
import com.example.catalogliceu.entities.ClasaMaterieProfesor;
import com.example.catalogliceu.entities.Liceu;
import com.example.catalogliceu.entities.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClasaMaterieProfesorRepository extends JpaRepository<ClasaMaterieProfesor, Long> {
    @Query("SELECT cmp FROM ClasaMaterieProfesor cmp WHERE cmp.clasa.liceu = :liceu")
    List<ClasaMaterieProfesor> findByLiceu(@Param("liceu") Liceu liceu);
    @Query("SELECT cmp FROM ClasaMaterieProfesor cmp WHERE cmp.clasa = :clasa")
    List<ClasaMaterieProfesor> findByClasa(@Param("clasa") Clasa clasa);
    @Query("SELECT cmp FROM ClasaMaterieProfesor cmp WHERE cmp.profesor = :profesor")
    List<ClasaMaterieProfesor> findByProfesor(@Param("profesor") Profesor profesor);
}
