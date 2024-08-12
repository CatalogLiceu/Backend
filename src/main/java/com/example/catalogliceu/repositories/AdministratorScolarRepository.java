package com.example.catalogliceu.repositories;

import com.example.catalogliceu.entities.Absenta;
import com.example.catalogliceu.entities.AdministratorScolar;
import com.example.catalogliceu.entities.Utilizator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdministratorScolarRepository extends JpaRepository<AdministratorScolar, Long> {
    Optional<AdministratorScolar> findByPorecla(String porecla);
}
