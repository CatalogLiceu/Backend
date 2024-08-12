package com.example.catalogliceu.service;

import com.example.catalogliceu.entities.Profil;
import com.example.catalogliceu.entities.Specializare;
import com.example.catalogliceu.exceptions.SpecializareInexistentaException;
import com.example.catalogliceu.repositories.SpecializareRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SpecializareService {
    private final SpecializareRepository specializareRepository;
    public SpecializareService(SpecializareRepository specializareRepository) {
        this.specializareRepository = specializareRepository;
    }
    public Specializare creeazaSpecializare(Profil profil, String nume) {
        Specializare specializare = Specializare.builder()
                .profil(profil)
                .nume(nume)
                .build();
        specializare = specializareRepository.save(specializare);
        return specializare;
    }
    public List<Specializare> extrageSpecializariProfil(Profil profil) {
        return specializareRepository.findByProfil(profil);
    }
    public Optional<Specializare> dupaId(Long id) {
        return specializareRepository.findById(id);
    }
    public List<Specializare> specializariDupaId(List<Long> id) {
        List<Specializare> specializari = new ArrayList<>();
        for(Long it : id) {
            Optional<Specializare> specializare = specializareRepository.findById(it);
            if(specializare.isEmpty()) {
                throw new SpecializareInexistentaException("Nu exista specializarea cu id: " + it);
            }
            specializari.add(specializare.get());
        }
        return specializari;
    }
}
