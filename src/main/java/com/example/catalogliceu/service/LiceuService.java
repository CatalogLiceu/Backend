package com.example.catalogliceu.service;

import com.example.catalogliceu.entities.*;
import com.example.catalogliceu.repositories.LiceuRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LiceuService {
    private final LiceuRepository liceuRepository;
    private final ClasaMaterieProfesorService clasaMaterieProfesorService;
    public LiceuService(LiceuRepository liceuRepository, ClasaMaterieProfesorService clasaMaterieProfesorService) {
        this.liceuRepository = liceuRepository;
        this.clasaMaterieProfesorService = clasaMaterieProfesorService;
    }
    public Liceu creeazaLiceu(List<Specializare> specializari, String nume) {
        Liceu liceu = Liceu.builder()
                .specializari(specializari)
                .nume(nume)
                .build();
        liceu = liceuRepository.save(liceu);
        return liceu;
    }
    public Optional<Liceu> dupaId(Long id) {
        return liceuRepository.findById(id);
    }
    public List<Liceu> toateLiceele() {
        return liceuRepository.findAll();
    }
    public List<Profesor> extrageProfesori(Liceu liceu) {
        List<ClasaMaterieProfesor> clasaMaterieProfesorList = clasaMaterieProfesorService.extrageDupaLiceu(liceu);
        List<Profesor> profesori = new ArrayList<>();
        for(ClasaMaterieProfesor it : clasaMaterieProfesorList) {
            profesori.add(it.getProfesor());
        }
        return profesori;
    }
}
