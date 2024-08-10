package com.example.catalogliceu.service;

import com.example.catalogliceu.entities.Profil;
import com.example.catalogliceu.entities.Specializare;
import com.example.catalogliceu.repositories.SpecializareRepository;
import org.springframework.stereotype.Service;

@Service
public class SpecializareService {
    private final SpecializareRepository specializareRepository;
    public SpecializareService(SpecializareRepository specializareRepository) {
        this.specializareRepository = specializareRepository;
    }
    public void creeazaSpecializare(Profil profil, String nume) {
        Specializare specializare = Specializare.builder()
                .profil(profil)
                .nume(nume)
                .build();
        specializareRepository.save(specializare);
    }
}
