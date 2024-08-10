package com.example.catalogliceu.service;

import com.example.catalogliceu.entities.Liceu;
import com.example.catalogliceu.entities.Specializare;
import com.example.catalogliceu.repositories.LiceuRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LiceuService {
    private final LiceuRepository liceuRepository;

    public LiceuService(LiceuRepository liceuRepository) {
        this.liceuRepository = liceuRepository;
    }
    public void creeazaLiceu(List<Specializare> specializari, String nume) {
        Liceu liceu = Liceu.builder()
                .specializari(specializari)
                .nume(nume)
                .build();
        liceuRepository.save(liceu);
    }
}
