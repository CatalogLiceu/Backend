package com.example.catalogliceu.controller;

import com.example.catalogliceu.dto.DateUtilizator;
import com.example.catalogliceu.entities.Clasa;
import com.example.catalogliceu.entities.Elev;
import com.example.catalogliceu.entities.Nota;
import com.example.catalogliceu.service.ClasaService;
import com.example.catalogliceu.service.ElevService;
import com.example.catalogliceu.service.NotaService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/elev")
@RequiredArgsConstructor
public class ElevController {
    private final ElevService elevService;
    private final ClasaService clasaService;
    private final NotaService notaService;
    @Operation(
            summary = "Adauga un elev la o anumita clasa"
    )
    @PostMapping("/clasa/{id}")
    public ResponseEntity<Elev> creeazaElev(
            @RequestBody DateUtilizator dateUtilizator,
            @PathVariable Long id
    ) {
        Optional<Clasa> clasaOptional = clasaService.dupaId(id);
        return clasaOptional.map(clasa -> ResponseEntity.ok(elevService.creeazaElev(dateUtilizator, clasa))).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @Operation(
            summary = "Extrage toate notele unui anumit elev"
    )
    @GetMapping("{id}/note")
    public ResponseEntity<List<Nota>> extrageNoteElev(
            @PathVariable Long id
    ) {
        Optional<Elev> elevOptional = elevService.dupaId(id);
        return elevOptional.map(elev -> ResponseEntity.ok(notaService.extrageNoteElev(elev))).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
