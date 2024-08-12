package com.example.catalogliceu.controller;

import com.example.catalogliceu.dto.DateSpecializare;
import com.example.catalogliceu.entities.Profil;
import com.example.catalogliceu.entities.Specializare;
import com.example.catalogliceu.service.ProfilService;
import com.example.catalogliceu.service.SpecializareService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/specializare")
@RequiredArgsConstructor
public class SpecializareController {
    private final ProfilService profilService;
    private final SpecializareService specializareService;
    @PostMapping("/")
    public ResponseEntity<Specializare> adaugaSpecializare(
            @RequestBody DateSpecializare dateSpecializare
    ) {
        Optional<Profil> profil = profilService.findById(dateSpecializare.getIdProfil());
        return profil.map(value -> ResponseEntity.ok(specializareService.creeazaSpecializare(value, dateSpecializare.getNume()))).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
