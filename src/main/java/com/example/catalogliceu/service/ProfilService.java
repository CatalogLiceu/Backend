package com.example.catalogliceu.service;

import com.example.catalogliceu.dto.DateProfil;
import com.example.catalogliceu.entities.Profil;
import com.example.catalogliceu.repositories.ProfilRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfilService {
    private final ProfilRepository profilRepository;
    public ProfilService(ProfilRepository profilRepository) {
        this.profilRepository = profilRepository;
    }
    public Profil creeazaProfil(DateProfil dateProfil) {
        Profil profil = Profil.builder()
                .nume(dateProfil.getNume())
                .build();
        profil = profilRepository.save(profil);
        return profil;
    }
    public List<Profil> toateProfilele() {
        return profilRepository.findAll();
    }
    public Optional<Profil> findById(Long id) {
        return profilRepository.findById(id);
    }
}
