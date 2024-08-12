package com.example.catalogliceu.controller;

import com.example.catalogliceu.dto.DateAnClasa;
import com.example.catalogliceu.entities.AnClasa;
import com.example.catalogliceu.service.AnClasaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/an_clasa")
@RequiredArgsConstructor
public class AnClasaController {
    private final AnClasaService anClasaService;
    @GetMapping("/")
    public ResponseEntity<List<AnClasa>> getAniClasa() {
        return ResponseEntity.ok(anClasaService.getAniClase());
    }
    @PostMapping("/")
    public ResponseEntity<AnClasa> createAniClasa(@RequestBody DateAnClasa dateAnClasa) {
        return ResponseEntity.ok(anClasaService.creeazaAn(dateAnClasa));
    }
}
