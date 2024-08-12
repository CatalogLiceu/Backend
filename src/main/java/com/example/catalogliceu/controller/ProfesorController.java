package com.example.catalogliceu.controller;

import com.example.catalogliceu.dto.DateProfesor;
import com.example.catalogliceu.entities.Profesor;
import com.example.catalogliceu.service.ProfesorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profesor")
@RequiredArgsConstructor
public class ProfesorController {
    private final ProfesorService profesorService;
    @PostMapping("/")
    public ResponseEntity<Profesor> creeazaProfesor(
            @RequestBody DateProfesor dateProfesor
    ) {
        return ResponseEntity.ok(profesorService.creeazaProfesor(dateProfesor));
    }
}
