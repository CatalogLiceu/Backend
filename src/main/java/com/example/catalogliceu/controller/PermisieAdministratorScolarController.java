package com.example.catalogliceu.controller;

import com.example.catalogliceu.dto.DatePermisieAdministrator;
import com.example.catalogliceu.entities.Liceu;
import com.example.catalogliceu.entities.PermisieAdministratorScolar;
import com.example.catalogliceu.entities.Utilizator;
import com.example.catalogliceu.service.LiceuService;
import com.example.catalogliceu.service.PermisieAdministratorService;
import com.example.catalogliceu.service.UtilizatorService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/permisie_administrator_scolar")
@RequiredArgsConstructor
public class PermisieAdministratorScolarController {
    private final PermisieAdministratorService permisieAdministratorService;
    private final UtilizatorService utilizatorService;
    private final LiceuService liceuService;
    @Operation(
            summary = "Adauga permisie de administrator scolar pentru un anumit liceu"
    )
    @GetMapping("")
    public ResponseEntity<PermisieAdministratorScolar> creeazaPermisie(
            @RequestBody DatePermisieAdministrator datePermisieAdministrator
    ) {
        Optional<Utilizator> utilizator = utilizatorService.dupaId(datePermisieAdministrator.getIdUtilizator());
        Optional<Liceu> liceu = liceuService.dupaId(datePermisieAdministrator.getIdLiceu());
        if(utilizator.isEmpty() || liceu.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(permisieAdministratorService.creeazaPermisieAdministrator(utilizator.get(), liceu.get()));
    }
    @Operation(
            summary = "Gaseste toate liceele la care utilizatorul are permisii de admisitrator"
    )
    @PostMapping("/utilizator/{id}")
    public ResponseEntity<List<PermisieAdministratorScolar>> extrageLiceeCuPermisie(
            @PathVariable Long id
    ) {
        Optional<Utilizator> utilizator = utilizatorService.dupaId(id);
        return utilizator.map(value -> ResponseEntity.ok(permisieAdministratorService.gasestePermisiiPentruUtilizator(value))).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
