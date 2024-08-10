package com.example.catalogliceu.repositories;

import com.example.catalogliceu.entities.Elev;
import com.example.catalogliceu.entities.Nota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotaRepository extends JpaRepository<Nota, Long> {
    List<Nota> findByElev(Elev elev);
}
