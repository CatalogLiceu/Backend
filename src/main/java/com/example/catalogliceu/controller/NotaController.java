package com.example.catalogliceu.controller;

import com.example.catalogliceu.dto.DateNota;
import com.example.catalogliceu.entities.*;
import com.example.catalogliceu.service.ElevService;
import com.example.catalogliceu.service.MaterieService;
import com.example.catalogliceu.service.NotaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/nota")
@RequiredArgsConstructor
public class NotaController {
    private final NotaService notaService;
    private final ElevService elevService;
    private final MaterieService materieService;
    @PostMapping("/")
    public ResponseEntity<Nota> creeazaNota(
            @RequestBody DateNota dateNota
    ) {
        Optional<Elev> elev = elevService.dupaId(dateNota.getIdElev());
        Optional<Materie> materie = materieService.dupaId(dateNota.getIdMaterie());
        if(elev.isEmpty() || materie.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(notaService.creeazaNota(dateNota.getValoare(), elev.get(), materie.get(), dateNota.getData()));
    }
}
