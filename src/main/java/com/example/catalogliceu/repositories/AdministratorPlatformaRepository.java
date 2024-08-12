package com.example.catalogliceu.repositories;

import com.example.catalogliceu.entities.AdministratorPlatforma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdministratorPlatformaRepository extends JpaRepository<AdministratorPlatforma, Long> {
    Optional<AdministratorPlatforma> findByPorecla(String porecla);
}
