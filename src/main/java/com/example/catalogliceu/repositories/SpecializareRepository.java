package com.example.catalogliceu.repositories;

import com.example.catalogliceu.entities.Profil;
import com.example.catalogliceu.entities.Specializare;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpecializareRepository extends JpaRepository<Specializare, Long> {
    List<Specializare> findByProfil(Profil profil);
}
