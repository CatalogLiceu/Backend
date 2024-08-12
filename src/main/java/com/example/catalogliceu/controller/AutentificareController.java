package com.example.catalogliceu.controller;

import com.example.catalogliceu.dto.CerereAutentificare;
import com.example.catalogliceu.dto.RaspunsAutentificare;
import com.example.catalogliceu.service.AutentificareService;
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
    @PostMapping("/login")
    public ResponseEntity<RaspunsAutentificare> login(
            @RequestBody CerereAutentificare cerereAutentificare
    ) {
        return ResponseEntity.ok(autentificareService.login(cerereAutentificare));
    }
}
