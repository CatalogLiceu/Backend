package com.example.catalogliceu.controller;

import com.example.catalogliceu.dto.CerereSchimbareNumePrenumeUtilizator;
import com.example.catalogliceu.entities.Utilizator;
import com.example.catalogliceu.service.UtilizatorService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/utilizator")
@RequiredArgsConstructor
public class UtilizatorController {
    private final UtilizatorService utilizatorService;
    @Operation(
            summary = "Extrage toti utilizatorii"
    )
    @GetMapping("")
    public ResponseEntity<List<Utilizator>> extrageTotiUtilizatorii() {
        return ResponseEntity.ok(utilizatorService.totiUtilizatorii());
    }
    @Operation(
            summary = "Schimba numele si prenumele unui utilizator"
    )
    @PutMapping("/{id}")
    public ResponseEntity<Utilizator> schimbaNumeUtilizator(
            @PathVariable Long id,
            @RequestBody CerereSchimbareNumePrenumeUtilizator cerereSchimbareNume
    ) {
        Optional<Utilizator> utilizator = utilizatorService.dupaId(id);
        return utilizator.map(value -> ResponseEntity.ok(utilizatorService.schimbaNumeUtilizator(value, cerereSchimbareNume))).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
