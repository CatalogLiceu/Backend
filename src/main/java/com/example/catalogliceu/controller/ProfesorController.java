package com.example.catalogliceu.controller;

import com.example.catalogliceu.dto.DateUtilizator;
import com.example.catalogliceu.entities.Profesor;
import com.example.catalogliceu.service.ProfesorService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profesor")
@RequiredArgsConstructor
public class ProfesorController {
    private final ProfesorService profesorService;
    @Operation(
            summary = "Adauga un profesor"
    )
    @PostMapping("")
    public ResponseEntity<Profesor> creeazaProfesor(
            @RequestBody DateUtilizator dateUtilizator
    ) {
        return ResponseEntity.ok(profesorService.creeazaProfesor(dateUtilizator));
    }
    @Operation(
            summary = "Extrage toti profesorii"
    )
    @GetMapping("")
    public ResponseEntity<List<Profesor>> getProfesori() {
        return ResponseEntity.ok(profesorService.totiProfesorii());
    }
}
