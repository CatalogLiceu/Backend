package com.example.catalogliceu.repositories;

import com.example.catalogliceu.entities.Absenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbsentaRepository extends JpaRepository<Absenta, Long> {
}
