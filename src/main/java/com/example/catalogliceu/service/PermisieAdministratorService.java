package com.example.catalogliceu.service;

import com.example.catalogliceu.entities.Liceu;
import com.example.catalogliceu.entities.PermisieAdministratorScolar;
import com.example.catalogliceu.entities.Utilizator;
import com.example.catalogliceu.repositories.PermisieAdministratorRepository;
import org.springframework.stereotype.Service;

@Service
public class PermisieAdministratorService {
    private final PermisieAdministratorRepository permisieAdministratorRepository;
    public PermisieAdministratorService(PermisieAdministratorRepository permisieAdministratorRepository) {
        this.permisieAdministratorRepository = permisieAdministratorRepository;
    }
    public void creeazaPermisieAdministrator(Utilizator utilizator, Liceu liceu) {
        PermisieAdministratorScolar permisieAdministratorScolar = PermisieAdministratorScolar.builder()
                .utilizator(utilizator)
                .liceu(liceu)
                .build();
        permisieAdministratorRepository.save(permisieAdministratorScolar);
    }
    public boolean extragerePermisieAdministrator(Utilizator utilizator, Liceu liceu) {
        return permisieAdministratorRepository.existsByUtilizatorAndLiceu(utilizator, liceu);
    }
}
