package com.example.catalogliceu.service;

import com.example.catalogliceu.entities.AdministratorPlatforma;
import com.example.catalogliceu.entities.Utilizator;
import com.example.catalogliceu.repositories.AdministratorPlatformaRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdministratorPlatformaService {
    private final AdministratorPlatformaRepository administratorPlatformaRepository;
    private final PasswordEncoder passwordEncoder;
    public AdministratorPlatformaService(AdministratorPlatformaRepository administratorPlatformaRepository, PasswordEncoder passwordEncoder) {
        this.administratorPlatformaRepository = administratorPlatformaRepository;
        this.passwordEncoder = passwordEncoder;
    }
    public void adaugaAdministratorPlatforma(Utilizator utilizator) {
        AdministratorPlatforma administratorPlatforma = AdministratorPlatforma.builder()
                .nume(utilizator.getNume())
                .prenume(utilizator.getPrenume())
                .email(utilizator.getEmail())
                .porecla(utilizator.getPorecla())
                .parola(passwordEncoder.encode(utilizator.getParola()))
                .build();
        administratorPlatformaRepository.save(administratorPlatforma);
    }
    public Boolean esteAdministratorPlatforma(Utilizator utilizator) {
        return administratorPlatformaRepository.findByPorecla(utilizator.getPorecla()).isPresent();
    }
    public Long nrAdministratoriPlatforma() {
        return administratorPlatformaRepository.count();
    }
}
