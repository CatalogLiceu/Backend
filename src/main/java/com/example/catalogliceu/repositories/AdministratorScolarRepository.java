package com.example.catalogliceu.repositories;

import com.example.catalogliceu.entities.AdministratorScolar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministratorScolarRepository extends JpaRepository<AdministratorScolar, Long> {
}
