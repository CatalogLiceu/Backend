package com.example.catalogliceu.service;

import com.example.catalogliceu.entities.Profesor;
import com.example.catalogliceu.repositories.ProfesorRepository;
import org.springframework.stereotype.Service;

@Service
public class ProfesorService {
    private final ProfesorRepository profesorRepository;
    public ProfesorService(ProfesorRepository profesorRepository) {
        this.profesorRepository = profesorRepository;
    }
    public void creeazaProfeor(String nume, String prenume, String email, String porecla, String parola) {
        Profesor profesor = Profesor.builder()
                .nume(nume)
                .prenume(prenume)
                .email(email)
                .porecla(porecla)
                .parola(parola)
                .build();
        profesorRepository.save(profesor);
    }
}
