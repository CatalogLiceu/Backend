package com.example.catalogliceu.controller;

import com.example.catalogliceu.dto.DateClasa;
import com.example.catalogliceu.dto.DateLiceu;
import com.example.catalogliceu.entities.*;
import com.example.catalogliceu.exceptions.SpecializareInexistentaException;
import com.example.catalogliceu.service.*;
import io.swagger.v3.oas.annotations.Operation;
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
    @Operation(
            summary = "Extrage toate liceele"
    )
    @GetMapping("")
    public ResponseEntity<List<Liceu>> getLicee() {
        return ResponseEntity.ok(liceuService.toateLiceele());
    }
    @Operation(
            summary = "Extrage datele unui anumit liceu"
    )
    @GetMapping("/{id}")
    public ResponseEntity<Liceu> getLiceu(
            @PathVariable Long id
    ) {
        Optional<Liceu> liceu = liceuService.dupaId(id);
        return liceu.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @Operation(
            summary = "Creeaza un liceu"
    )
    @PostMapping("")
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
    @Operation(
            summary = "Extrage profesorii de la un anumit liceu"
    )
    @GetMapping("/{id}/profesori")
    public ResponseEntity<List<Profesor>> extrageProfesori(@PathVariable Long id) {
        Optional<Liceu> liceu = liceuService.dupaId(id);
        return liceu.map(value -> ResponseEntity.ok(liceuService.extrageProfesori(value))).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @Operation(
            summary = "Extrage clasele de la un anumit liceu"
    )
    @GetMapping("/{id}/clase")
    public ResponseEntity<List<Clasa>> extrageClase(@PathVariable Long id) {
        Optional<Liceu> liceu = liceuService.dupaId(id);
        return liceu.map(value -> ResponseEntity.ok(clasaService.extrageDupaLiceu(value))).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @Operation(
            summary = "Creeaza o clasa pentru un anumit liceu"
    )
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
