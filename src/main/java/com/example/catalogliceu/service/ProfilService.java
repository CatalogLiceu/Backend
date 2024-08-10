package com.example.catalogliceu.service;

import com.example.catalogliceu.entities.Profil;
import com.example.catalogliceu.repositories.ProfilRepository;
import org.springframework.stereotype.Service;

@Service
public class ProfilService {
    private final ProfilRepository profilRepository;
    public ProfilService(ProfilRepository profilRepository) {
        this.profilRepository = profilRepository;
    }
    public void creeazaProfil(String nume) {
        Profil profil = Profil.builder()
                .nume(nume)
                .build();
        profilRepository.save(profil);
    }
}
