package com.example.catalogliceu.service;

import com.example.catalogliceu.dto.DateProfesor;
import com.example.catalogliceu.entities.Profesor;
import com.example.catalogliceu.entities.Utilizator;
import com.example.catalogliceu.repositories.ProfesorRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ProfesorService {
    private final ProfesorRepository profesorRepository;
    private final PasswordEncoder passwordEncoder;
    public ProfesorService(ProfesorRepository profesorRepository, PasswordEncoder passwordEncoder) {
        this.profesorRepository = profesorRepository;
        this.passwordEncoder = passwordEncoder;
    }
    public Profesor creeazaProfesor(DateProfesor dateProfesor) {
        Profesor profesor = Profesor.builder()
                .nume(dateProfesor.getNume())
                .prenume(dateProfesor.getPrenume())
                .email(dateProfesor.getEmail())
                .porecla(dateProfesor.getPorecla())
                .parola(passwordEncoder.encode(dateProfesor.getParola()))
                .build();
        profesor = profesorRepository.save(profesor);
        return profesor;
    }

    public Boolean esteProfesor(Utilizator utilizator) {
        return profesorRepository.findByPorecla(utilizator.getPorecla()).isPresent();
    }
}
