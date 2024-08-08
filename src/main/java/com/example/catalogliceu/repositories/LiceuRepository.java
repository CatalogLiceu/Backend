package com.example.catalogliceu.repositories;

import com.example.catalogliceu.entities.Liceu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LiceuRepository extends JpaRepository<Liceu, Long> {
}
