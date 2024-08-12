package com.example.catalogliceu.service;

import com.example.catalogliceu.dto.CerereInregistrareAdministratorScolar;
import com.example.catalogliceu.entities.AdministratorScolar;
import com.example.catalogliceu.entities.Liceu;
import com.example.catalogliceu.entities.Utilizator;
import com.example.catalogliceu.exceptions.LiceuInexistentException;
import com.example.catalogliceu.repositories.AdministratorScolarRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdministratorScolarService {
    private final AdministratorScolarRepository administratorScolarRepository;
    private final LiceuService liceuService;
    private final PasswordEncoder passwordEncoder;
    public AdministratorScolarService(AdministratorScolarRepository administratorScolarRepository, LiceuService liceuService, PasswordEncoder passwordEncoder) {
        this.administratorScolarRepository = administratorScolarRepository;
        this.liceuService = liceuService;
        this.passwordEncoder = passwordEncoder;
    }
    public AdministratorScolar adaugaAdministratorScolar(CerereInregistrareAdministratorScolar cerereInregistrareAdministratorScolar) {
        Liceu liceu = liceuService.dupaId(cerereInregistrareAdministratorScolar.getIdLiceu())
                .orElseThrow(() -> new LiceuInexistentException("Liceu inexistent: " + cerereInregistrareAdministratorScolar.getIdLiceu()));
        AdministratorScolar administratorScolar = AdministratorScolar.builder()
                .nume(cerereInregistrareAdministratorScolar.getCerereInregistrareUtilizator().getNume())
                .prenume(cerereInregistrareAdministratorScolar.getCerereInregistrareUtilizator().getPrenume())
                .email(cerereInregistrareAdministratorScolar.getCerereInregistrareUtilizator().getEmail())
                .porecla(cerereInregistrareAdministratorScolar.getCerereInregistrareUtilizator().getPorecla())
                .parola(passwordEncoder.encode(cerereInregistrareAdministratorScolar.getCerereInregistrareUtilizator().getParola()))
                .liceu(liceu)
                .build();
        administratorScolarRepository.save(administratorScolar);
        return administratorScolar;
    }

    public Boolean esteAdministratorScolar(Utilizator utilizator) {
        return administratorScolarRepository.findByPorecla(utilizator.getPorecla()).isPresent();
    }
}
