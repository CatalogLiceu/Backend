package com.example.catalogliceu.controller;

import com.example.catalogliceu.dto.CerereInregistrareAdministratorScolar;
import com.example.catalogliceu.entities.AdministratorScolar;
import com.example.catalogliceu.service.AdministratorScolarService;
import com.example.catalogliceu.service.PermisieAdministratorService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/administrator_scolar")
@RequiredArgsConstructor
public class AdministratorScolarController {
    private final AdministratorScolarService administratorScolarService;
    private final PermisieAdministratorService permisieAdministratorService;
    @Operation(
            summary = "Adauga un administrator scolar pentru un anumit liceu"
    )
    @PostMapping("")
    public ResponseEntity<AdministratorScolar> adaugaAdministratorScolar(
            @RequestBody CerereInregistrareAdministratorScolar cerereInregistrareAdministratorScolar
    ) {
        AdministratorScolar createdAdministrator = administratorScolarService.adaugaAdministratorScolar(cerereInregistrareAdministratorScolar);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAdministrator);
    }
}
