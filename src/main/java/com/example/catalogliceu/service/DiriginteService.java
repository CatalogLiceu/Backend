package com.example.catalogliceu.service;

import com.example.catalogliceu.entities.Clasa;
import com.example.catalogliceu.entities.Diriginte;
import com.example.catalogliceu.entities.Profesor;
import com.example.catalogliceu.repositories.DiriginteRepository;
import org.springframework.stereotype.Service;

@Service
public class DiriginteService {
    private final DiriginteRepository diriginteRepository;
    public DiriginteService(DiriginteRepository diriginteRepository) {
        this.diriginteRepository = diriginteRepository;
    }
    public void adaugaDiriginte(Clasa clasa, Profesor profesor) {
        Diriginte diriginte = Diriginte.builder()
                .clasa(clasa)
                .profesor(profesor)
                .build();
        diriginteRepository.save(diriginte);
    }
}
