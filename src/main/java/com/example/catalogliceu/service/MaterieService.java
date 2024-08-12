package com.example.catalogliceu.service;

import com.example.catalogliceu.entities.AnClasa;
import com.example.catalogliceu.entities.Materie;
import com.example.catalogliceu.entities.Specializare;
import com.example.catalogliceu.repositories.MaterieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterieService {
    private final MaterieRepository materieRepository;
    public MaterieService(MaterieRepository materieRepository) {
        this.materieRepository = materieRepository;
    }
    public Materie creeazaMaterie(List<Specializare> specializari, List<AnClasa> aniClase, String nume) {
        Materie materie = Materie.builder()
                .specializari(specializari)
                .aniClase(aniClase)
                .nume(nume)
                .build();
        materie = materieRepository.save(materie);
        return materie;
    }
}
