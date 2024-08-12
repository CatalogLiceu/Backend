package com.example.catalogliceu.repositories;

import com.example.catalogliceu.entities.Materie;
import com.example.catalogliceu.entities.Specializare;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaterieRepository extends JpaRepository<Materie, Long> {
    List<Materie> findBySpecializari(Specializare specializare);
}
