package com.example.catalogliceu.controller;

import com.example.catalogliceu.entities.Clasa;
import com.example.catalogliceu.entities.Diriginte;
import com.example.catalogliceu.entities.Elev;
import com.example.catalogliceu.service.ClasaService;
import com.example.catalogliceu.service.DiriginteService;
import com.example.catalogliceu.service.ElevService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clasa")
@RequiredArgsConstructor
public class ClasaController {
    private final ElevService elevService;
    private final ClasaService clasaService;
    private final DiriginteService diriginteService;
    @Operation(
            summary = "Extrage toti elevii dintr-o anumita clasa"
    )
    @GetMapping("/{id}/elevi")
    public ResponseEntity<List<Elev>> extrageElevi(
            @PathVariable Long id
    ) {
        Optional<Clasa> clasaOptional = clasaService.dupaId(id);
        return clasaOptional.map(clasa -> ResponseEntity.ok(elevService.extrageDupaClasa(clasa))).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @Operation(
            summary = "Extrage dirigintele unei anumite clase"
    )
    @GetMapping("{id}/diriginte")
    public ResponseEntity<Diriginte> extrageDiriginte(
            @PathVariable Long id
    ) {
        Optional<Clasa> clasaOptional = clasaService.dupaId(id);
        if(clasaOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Optional<Diriginte> diriginteOptional = diriginteService.extrageDiriginteClasa(clasaOptional.get());
        return diriginteOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
