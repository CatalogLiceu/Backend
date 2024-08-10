package com.example.catalogliceu.service;

import com.example.catalogliceu.entities.Clasa;
import com.example.catalogliceu.entities.ClasaMaterieProfesor;
import com.example.catalogliceu.entities.Materie;
import com.example.catalogliceu.entities.Profesor;
import com.example.catalogliceu.repositories.ClasaMaterieProfesorRepository;
import org.springframework.stereotype.Service;

@Service
public class ClasaMaterieProfesorService {
    private final ClasaMaterieProfesorRepository clasasMaterieProfesorRepository;
    public ClasaMaterieProfesorService(ClasaMaterieProfesorRepository clasaMaterieProfesorRepository) {
        this.clasasMaterieProfesorRepository = clasaMaterieProfesorRepository;
    }
    public void creeazaClasaMaterieProfesor(Clasa clasa, Materie materie, Profesor profesor) {
        ClasaMaterieProfesor clasaMaterieProfesor = ClasaMaterieProfesor.builder()
                .clasa(clasa)
                .materie(materie)
                .profesor(profesor)
                .build();
        clasasMaterieProfesorRepository.save(clasaMaterieProfesor);
    }
}
