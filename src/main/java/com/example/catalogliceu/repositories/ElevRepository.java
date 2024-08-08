package com.example.catalogliceu.repositories;

import com.example.catalogliceu.entities.Elev;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElevRepository extends JpaRepository<Elev, Long> {
}
