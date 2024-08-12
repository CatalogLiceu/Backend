package com.example.catalogliceu.controller;

import com.example.catalogliceu.dto.DateClasa;
import com.example.catalogliceu.dto.DateLiceu;
import com.example.catalogliceu.entities.*;
import com.example.catalogliceu.exceptions.SpecializareInexistentaException;
import com.example.catalogliceu.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/liceu")
@RequiredArgsConstructor
public class LiceuController {
    private final LiceuService liceuService;
    private final SpecializareService specializareService;
    private final ClasaService clasaService;
    private final AnClasaService anClasaService;

    @GetMapping("/")
    public ResponseEntity<List<Liceu>> getLicee() {
        return ResponseEntity.ok(liceuService.toateLiceele());
    }
    @PostMapping("/")
    public ResponseEntity<Liceu> creeazaLiceu(
            @RequestBody DateLiceu dateLiceu
    ) {
        List<Specializare> specializari;
        try {
            specializari = specializareService.specializariDupaId(dateLiceu.getIdSpecializari());
        }
        catch(SpecializareInexistentaException e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(liceuService.creeazaLiceu(specializari, dateLiceu.getNume()));
    }
    @GetMapping("/{id}/profesori")
    public ResponseEntity<List<Profesor>> extrageProfesori(@PathVariable Long id) {
        Optional<Liceu> liceu = liceuService.dupaId(id);
        return liceu.map(value -> ResponseEntity.ok(liceuService.extrageProfesori(value))).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @GetMapping("/{id}/clase")
    public ResponseEntity<List<Clasa>> extrageClase(@PathVariable Long id) {
        Optional<Liceu> liceu = liceuService.dupaId(id);
        return liceu.map(value -> ResponseEntity.ok(clasaService.extrageDupaLiceu(value))).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping("/{id}/clasa")
    public ResponseEntity<Clasa> creeazaClasa(
            @RequestBody DateClasa dateClasa,
            @PathVariable Long id) {
        Optional<Liceu> liceu = liceuService.dupaId(id);
        Optional<AnClasa> anClasa = anClasaService.dupaId(dateClasa.getIdAnClasa());
        Optional<Specializare> specializare = specializareService.dupaId(dateClasa.getIdSpecializare());
        if(liceu.isEmpty() || anClasa.isEmpty() || specializare.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(clasaService.creeazaClasa(liceu.get(), anClasa.get(), dateClasa.getLitera(), specializare.get()));
    }
}
