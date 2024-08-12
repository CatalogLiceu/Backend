package com.example.catalogliceu.controller;

import com.example.catalogliceu.dto.DatePermisieAdministrator;
import com.example.catalogliceu.dto.DateUtilizator;
import com.example.catalogliceu.entities.Liceu;
import com.example.catalogliceu.entities.PermisieAdministratorScolar;
import com.example.catalogliceu.entities.Profesor;
import com.example.catalogliceu.entities.Utilizator;
import com.example.catalogliceu.service.LiceuService;
import com.example.catalogliceu.service.PermisieAdministratorService;
import com.example.catalogliceu.service.UtilizatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/permisie_administrator_scolar")
@RequiredArgsConstructor
public class PermisieAdministratorScolarController {
    private final PermisieAdministratorService permisieAdministratorService;
    private final UtilizatorService utilizatorService;
    private final LiceuService liceuService;
    @PostMapping("")
    public ResponseEntity<PermisieAdministratorScolar> creeazaPermisie(
            @RequestBody DatePermisieAdministrator datePermisieAdministrator
    ) {
        Optional<Utilizator> utilizator = utilizatorService.dupaId(datePermisieAdministrator.getIdUtilizator());
        Optional<Liceu> liceu = liceuService.dupaId(datePermisieAdministrator.getIdLiceu());
        if(utilizator.isEmpty() || liceu.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(permisieAdministratorService.creeazaPermisieAdministrator(utilizator.get(), liceu.get()));
    }
}
