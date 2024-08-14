package com.example.catalogliceu.controller;

import com.example.catalogliceu.dto.DateAnClasa;
import com.example.catalogliceu.entities.AnClasa;
import com.example.catalogliceu.service.AnClasaService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/an_clasa")
@RequiredArgsConstructor
public class AnClasaController {
    private final AnClasaService anClasaService;
    @Operation(
            summary = "Extrage anii existenti pt. clase"
    )
    @GetMapping("")
    public ResponseEntity<List<AnClasa>> getAniClasa() {
        return ResponseEntity.ok(anClasaService.getAniClase());
    }
    @Operation(
            summary = "Adauga un an nou pt. clase"
    )
    @PostMapping("")
    public ResponseEntity<AnClasa> createAniClasa(@RequestBody DateAnClasa dateAnClasa) {
        if(dateAnClasa.getNrClasa() < 9 || dateAnClasa.getNrClasa() > 13) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(anClasaService.creeazaAn(dateAnClasa));
    }
}
