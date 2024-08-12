package com.example.catalogliceu.controller;

import com.example.catalogliceu.dto.DateClasaMaterieProfesor;
import com.example.catalogliceu.entities.*;
import com.example.catalogliceu.service.ClasaMaterieProfesorService;
import com.example.catalogliceu.service.ClasaService;
import com.example.catalogliceu.service.MaterieService;
import com.example.catalogliceu.service.ProfesorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/clasa_materie_profesor")
@RequiredArgsConstructor
public class ClasaMaterieProfesorController {
    private final ClasaMaterieProfesorService clasaMaterieProfesorService;
    private final ClasaService clasaService;
    private final MaterieService materieService;
    private final ProfesorService profesorService;
    @PostMapping("/")
    public ResponseEntity<ClasaMaterieProfesor> creeazaClasaMaterieProfesor(
            @RequestBody DateClasaMaterieProfesor dateClasaMaterieProfesor
    ) {
        Optional<Clasa> clasa = clasaService.dupaId(dateClasaMaterieProfesor.getIdClasa());
        Optional<Materie> materie = materieService.dupaId(dateClasaMaterieProfesor.getIdClasa());
        Optional<Profesor> profesor = profesorService.dupaId(dateClasaMaterieProfesor.getIdProfesor());
        if(clasa.isEmpty() || materie.isEmpty() || profesor.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(clasaMaterieProfesorService.creeazaClasaMaterieProfesor(clasa.get(), materie.get(), profesor.get()));
    }
    @GetMapping("/clasa/{id}")
    public ResponseEntity<List<ClasaMaterieProfesor>> dupaClasa(
            @PathVariable Long id
    ) {
        Optional<Clasa> clasaOptional = clasaService.dupaId(id);
        if (clasaOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Clasa clasa = clasaOptional.get();
        List<ClasaMaterieProfesor> existingList = clasaMaterieProfesorService.extrageDupaClasa(clasa);
        HashSet<Materie> existingMaterii = existingList.stream()
                .map(ClasaMaterieProfesor::getMaterie)
                .collect(Collectors.toCollection(HashSet::new));
        List<Materie> materieList = materieService.dupaSpecializare(clasa.getSpecializare());
        HashSet<ClasaMaterieProfesor> updatedSet = new HashSet<>(existingList);
        for (Materie materie : materieList) {
            if (!existingMaterii.contains(materie)) {
                ClasaMaterieProfesor newEntry = ClasaMaterieProfesor.builder()
                        .clasa(clasa)
                        .materie(materie)
                        .profesor(null)
                        .build();
                updatedSet.add(newEntry);
            }
        }
        return ResponseEntity.ok(new ArrayList<>(updatedSet));
    }
}
