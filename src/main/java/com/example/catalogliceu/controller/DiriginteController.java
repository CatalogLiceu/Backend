package com.example.catalogliceu.controller;

import com.example.catalogliceu.dto.DateDiriginte;
import com.example.catalogliceu.entities.Clasa;
import com.example.catalogliceu.entities.Diriginte;
import com.example.catalogliceu.entities.Profesor;
import com.example.catalogliceu.service.ClasaService;
import com.example.catalogliceu.service.DiriginteService;
import com.example.catalogliceu.service.ProfesorService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/diriginte")
@RequiredArgsConstructor
public class DiriginteController {
    private final DiriginteService diriginteService;
    private final ClasaService clasaService;
    private final ProfesorService profesorService;
    @Operation(
            summary = "Adauga un diriginte pentru o clasa"
    )
    @PostMapping("")
    public ResponseEntity<Diriginte> creeazaDiriginte(
            @RequestBody DateDiriginte dateDiriginte
    ) {
        Optional<Profesor> profesor = profesorService.dupaId(dateDiriginte.getIdProfesor());
        Optional<Clasa> clasa = clasaService.dupaId(dateDiriginte.getIdClasa());
        if(profesor.isEmpty() || clasa.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(diriginteService.creeazaDiriginte(clasa.get(), profesor.get()));
    }
}
