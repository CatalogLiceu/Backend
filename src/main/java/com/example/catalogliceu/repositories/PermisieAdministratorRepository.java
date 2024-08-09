package com.example.catalogliceu.repositories;

import com.example.catalogliceu.entities.PermisieAdministrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermisieAdministratorRepository extends JpaRepository<PermisieAdministrator, Long> {
}
