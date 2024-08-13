package com.example.catalogliceu.controller;

import com.example.catalogliceu.dto.CerereAutentificare;
import com.example.catalogliceu.dto.RaspunsAutentificare;
import com.example.catalogliceu.service.AutentificareService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autentificare")
@RequiredArgsConstructor
public class AutentificareController {
    private final AutentificareService autentificareService;
    @Operation(
            summary = "Logare, returneaza JWT"
    )
    @PostMapping("/login")
    public ResponseEntity<RaspunsAutentificare> login(
            @RequestBody CerereAutentificare cerereAutentificare
    ) {
        return ResponseEntity.ok(autentificareService.login(cerereAutentificare));
    }
}
