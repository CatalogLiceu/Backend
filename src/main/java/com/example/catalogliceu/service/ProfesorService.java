package com.example.catalogliceu.service;

import com.example.catalogliceu.dto.DateUtilizator;
import com.example.catalogliceu.entities.Profesor;
import com.example.catalogliceu.entities.Utilizator;
import com.example.catalogliceu.repositories.ProfesorRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfesorService {
    private final ProfesorRepository profesorRepository;
    private final PasswordEncoder passwordEncoder;
    public ProfesorService(ProfesorRepository profesorRepository, PasswordEncoder passwordEncoder) {
        this.profesorRepository = profesorRepository;
        this.passwordEncoder = passwordEncoder;
    }
    public Profesor creeazaProfesor(DateUtilizator dateUtilizator) {
        Profesor profesor = Profesor.builder()
                .nume(dateUtilizator.getNume())
                .prenume(dateUtilizator.getPrenume())
                .email(dateUtilizator.getEmail())
                .porecla(dateUtilizator.getPorecla())
                .parola(passwordEncoder.encode(dateUtilizator.getParola()))
                .build();
        profesor = profesorRepository.save(profesor);
        return profesor;
    }

    public Boolean esteProfesor(Utilizator utilizator) {
        return profesorRepository.findByPorecla(utilizator.getPorecla()).isPresent();
    }
    public Optional<Profesor> dupaId(Long id) {
        return profesorRepository.findById(id);
    }
    public List<Profesor> totiProfesorii() {
        return profesorRepository.findAll();
    }
}
