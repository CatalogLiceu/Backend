package com.example.catalogliceu.service;

import com.example.catalogliceu.entities.Clasa;
import com.example.catalogliceu.entities.Elev;
import com.example.catalogliceu.entities.Utilizator;
import com.example.catalogliceu.repositories.ElevRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ElevService {
    private final ElevRepository elevRepository;
    private final PasswordEncoder passwordEncoder;
    public ElevService(ElevRepository elevRepository, PasswordEncoder passwordEncoder) {
        this.elevRepository = elevRepository;
        this.passwordEncoder = passwordEncoder;
    }
    public void creeazaElev(String nume, String prenume, String email, String porecla, String parola, Clasa clasa) {
        Elev elev = Elev.builder()
                .nume(nume)
                .prenume(prenume)
                .email(email)
                .porecla(porecla)
                .parola(passwordEncoder.encode(parola))
                .clasa(clasa)
                .build();
        elevRepository.save(elev);
    }

    public Boolean esteElev(Utilizator utilizator) {
        return elevRepository.findByPorecla(utilizator.getPorecla()).isPresent();
    }
}
