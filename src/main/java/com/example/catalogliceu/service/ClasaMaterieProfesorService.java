package com.example.catalogliceu.service;

import com.example.catalogliceu.entities.*;
import com.example.catalogliceu.repositories.ClasaMaterieProfesorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClasaMaterieProfesorService {
    private final ClasaMaterieProfesorRepository clasaMaterieProfesorRepository;
    public ClasaMaterieProfesorService(ClasaMaterieProfesorRepository clasaMaterieProfesorRepository) {
        this.clasaMaterieProfesorRepository = clasaMaterieProfesorRepository;
    }
    public ClasaMaterieProfesor creeazaClasaMaterieProfesor(Clasa clasa, Materie materie, Profesor profesor) {
        ClasaMaterieProfesor clasaMaterieProfesor = ClasaMaterieProfesor.builder()
                .clasa(clasa)
                .materie(materie)
                .profesor(profesor)
                .build();
        clasaMaterieProfesor = clasaMaterieProfesorRepository.save(clasaMaterieProfesor);
        return clasaMaterieProfesor;
    }
    public List<ClasaMaterieProfesor> extrageDupaLiceu(Liceu liceu) {
        return clasaMaterieProfesorRepository.findByLiceu(liceu);
    }
    public List<ClasaMaterieProfesor> extrageDupaClasa(Clasa clasa) {
        return clasaMaterieProfesorRepository.findByClasa(clasa);
    }
    public List<ClasaMaterieProfesor> extrageDupaProfesor(Profesor profesor) {
        return clasaMaterieProfesorRepository.findByProfesor(profesor);
    }
}
