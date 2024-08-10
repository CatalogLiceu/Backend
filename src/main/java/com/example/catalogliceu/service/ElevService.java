package com.example.catalogliceu.service;

import com.example.catalogliceu.entities.Clasa;
import com.example.catalogliceu.entities.Elev;
import com.example.catalogliceu.repositories.ElevRepository;
import org.springframework.stereotype.Service;

@Service
public class ElevService {
    private final ElevRepository elevRepository;
    public ElevService(ElevRepository elevRepository) {
        this.elevRepository = elevRepository;
    }
    public void creeazaElev(String nume, String prenume, String email, String porecla, String parola, Clasa clasa) {
        Elev elev = Elev.builder()
                .nume(nume)
                .prenume(prenume)
                .email(email)
                .porecla(porecla)
                .parola(parola)
                .clasa(clasa)
                .build();
        elevRepository.save(elev);
    }
}
