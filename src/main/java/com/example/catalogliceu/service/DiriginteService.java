package com.example.catalogliceu.service;

import com.example.catalogliceu.entities.Clasa;
import com.example.catalogliceu.entities.Diriginte;
import com.example.catalogliceu.entities.Profesor;
import com.example.catalogliceu.repositories.DiriginteRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DiriginteService {
    private final DiriginteRepository diriginteRepository;
    public DiriginteService(DiriginteRepository diriginteRepository) {
        this.diriginteRepository = diriginteRepository;
    }
    public Diriginte creeazaDiriginte(Clasa clasa, Profesor profesor) {
        Diriginte diriginte = Diriginte.builder()
                .clasa(clasa)
                .profesor(profesor)
                .build();
        diriginte = diriginteRepository.save(diriginte);
        return diriginte;
    }
    public Optional<Diriginte> extrageDiriginteClasa(Clasa clasa) {
        return diriginteRepository.findByClasa(clasa);
    }
}
