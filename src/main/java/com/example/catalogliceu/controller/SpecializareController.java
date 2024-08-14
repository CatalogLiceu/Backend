package com.example.catalogliceu.controller;

import com.example.catalogliceu.dto.DateSpecializare;
import com.example.catalogliceu.entities.Profil;
import com.example.catalogliceu.entities.Specializare;
import com.example.catalogliceu.service.ProfilService;
import com.example.catalogliceu.service.SpecializareService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/specializare")
@RequiredArgsConstructor
public class SpecializareController {
    private final ProfilService profilService;
    private final SpecializareService specializareService;
    @Operation(
            summary = "Adauga o specializare la un anumit profil"
    )
    @PostMapping("")
    public ResponseEntity<Specializare> adaugaSpecializare(
            @RequestBody DateSpecializare dateSpecializare
    ) {
        Optional<Profil> profil = profilService.findById(dateSpecializare.getIdProfil());
        return profil.map(value -> ResponseEntity.ok(specializareService.creeazaSpecializare(value, dateSpecializare.getNume()))).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @Operation(
            summary = "Extrage toate specializarile"
    )
    @GetMapping("")
    public ResponseEntity<List<Specializare>> extrageSpecializari(
    ) {
        return ResponseEntity.ok(specializareService.extrageToate());
    }
}
