package com.example.catalogliceu.controller;

import com.example.catalogliceu.dto.DateNota;
import com.example.catalogliceu.entities.*;
import com.example.catalogliceu.service.ElevService;
import com.example.catalogliceu.service.MaterieService;
import com.example.catalogliceu.service.NotaService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/nota")
@RequiredArgsConstructor
public class NotaController {
    private final NotaService notaService;
    private final ElevService elevService;
    private final MaterieService materieService;
    @Operation(
            summary = "Adauga o nota pentru un elev si materie"
    )
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
    @Operation(
            summary = "Extrage toate notele unui elev la o anumita materie"
    )
    @GetMapping("/elev/{id_elev}/materie/{id_materie}")
    public ResponseEntity<List<Nota>> extrageNoteElevMaterie(
            @PathVariable Long id_elev,
            @PathVariable Long id_materie
    ) {
        Optional<Elev> elev = elevService.dupaId(id_elev);
        Optional<Materie> materie = materieService.dupaId(id_materie);
        if(elev.isEmpty() || materie.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(notaService.extrageNoteElevMaterie(elev.get(), materie.get()));
    }
}
