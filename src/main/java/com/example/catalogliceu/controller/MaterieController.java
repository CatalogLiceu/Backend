package com.example.catalogliceu.controller;

import com.example.catalogliceu.dto.DateMaterie;
import com.example.catalogliceu.entities.AnClasa;
import com.example.catalogliceu.entities.Materie;
import com.example.catalogliceu.entities.Specializare;
import com.example.catalogliceu.exceptions.SpecializareInexistentaException;
import com.example.catalogliceu.service.AnClasaService;
import com.example.catalogliceu.service.MaterieService;
import com.example.catalogliceu.service.SpecializareService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/materie")
@RequiredArgsConstructor
public class MaterieController {
    private final MaterieService materieService;
    private final SpecializareService specializareService;
    private final AnClasaService anClasaService;
    @PostMapping("/")
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
}
