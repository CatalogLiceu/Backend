package com.example.catalogliceu.controller;

import com.example.catalogliceu.dto.CerereSchimbareNumeMaterie;
import com.example.catalogliceu.dto.DateMaterie;
import com.example.catalogliceu.entities.AnClasa;
import com.example.catalogliceu.entities.Materie;
import com.example.catalogliceu.entities.Specializare;
import com.example.catalogliceu.exceptions.SpecializareInexistentaException;
import com.example.catalogliceu.service.AnClasaService;
import com.example.catalogliceu.service.MaterieService;
import com.example.catalogliceu.service.SpecializareService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/materie")
@RequiredArgsConstructor
public class MaterieController {
    private final MaterieService materieService;
    private final SpecializareService specializareService;
    private final AnClasaService anClasaService;
    @Operation(
            summary = "Adauga o materie valabila pentru o multime de specializari si ani scolari"
    )
    @PostMapping("")
    public ResponseEntity<Materie> creeazaMaterie(
            @RequestBody DateMaterie dateMaterie
    ) {
        List<Specializare> specializari;
        List<AnClasa> aniClase;
        try {
            specializari = specializareService.specializariDupaId(dateMaterie.getIdSpecializari());
            aniClase = anClasaService.aniClasaDupaId(dateMaterie.getIdAniClase());
        }
        catch(SpecializareInexistentaException e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(materieService.creeazaMaterie(specializari, aniClase, dateMaterie.getNume()));
    }
    @Operation(
            summary = "Schimba numele unei materii"
    )
    @PutMapping("/{id}")
    public ResponseEntity<Materie> schimbaNumeMaterie(
            @PathVariable Long id,
            @RequestBody CerereSchimbareNumeMaterie cerereSchimbareNumeMaterie
    ) {
        Optional<Materie> materie = materieService.dupaId(id);
        return materie.map(value -> ResponseEntity.ok(materieService.schimbaNumeMaterie(value, cerereSchimbareNumeMaterie))).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @Operation(
            summary = "Extrage toate materiile"
    )
    @GetMapping("")
    public ResponseEntity<List<Materie>> extrageMaterii(
    ) {
       return ResponseEntity.ok(materieService.extrageToate());
    }
}
