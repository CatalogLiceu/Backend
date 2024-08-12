package com.example.catalogliceu.service;

import com.example.catalogliceu.entities.AnClasa;
import com.example.catalogliceu.entities.Materie;
import com.example.catalogliceu.entities.Specializare;
import com.example.catalogliceu.repositories.MaterieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Optional<Materie> dupaId(Long id) {
        return materieRepository.findById(id);
    }
    public List<Materie> dupaSpecializare(Specializare specializare) {
        return materieRepository.findBySpecializari(specializare);
    }
}
