package com.example.catalogliceu.repositories;

import com.example.catalogliceu.entities.Liceu;
import com.example.catalogliceu.entities.PermisieAdministratorScolar;
import com.example.catalogliceu.entities.Utilizator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermisieAdministratorRepository extends JpaRepository<PermisieAdministratorScolar, Long> {
    boolean existsByUtilizatorAndLiceu(Utilizator utilizator, Liceu liceu);
}
