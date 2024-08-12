package com.example.catalogliceu.service;

import com.example.catalogliceu.entities.*;
import com.example.catalogliceu.repositories.ClasaMaterieProfesorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClasaMaterieProfesorService {
    private final ClasaMaterieProfesorRepository clasasMaterieProfesorRepository;
    public ClasaMaterieProfesorService(ClasaMaterieProfesorRepository clasaMaterieProfesorRepository) {
        this.clasasMaterieProfesorRepository = clasaMaterieProfesorRepository;
    }
    public ClasaMaterieProfesor creeazaClasaMaterieProfesor(Clasa clasa, Materie materie, Profesor profesor) {
        ClasaMaterieProfesor clasaMaterieProfesor = ClasaMaterieProfesor.builder()
                .clasa(clasa)
                .materie(materie)
                .profesor(profesor)
                .build();
        clasaMaterieProfesor = clasasMaterieProfesorRepository.save(clasaMaterieProfesor);
        return clasaMaterieProfesor;
    }
    public List<ClasaMaterieProfesor> extrageDupaLiceu(Liceu liceu) {
        return clasasMaterieProfesorRepository.findByLiceu(liceu);
    }
}
