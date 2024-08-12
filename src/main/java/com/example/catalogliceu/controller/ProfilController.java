package com.example.catalogliceu.controller;

import com.example.catalogliceu.dto.DateProfil;
import com.example.catalogliceu.entities.Profil;
import com.example.catalogliceu.entities.Specializare;
import com.example.catalogliceu.service.ProfilService;
import com.example.catalogliceu.service.SpecializareService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/profil")
@RequiredArgsConstructor
public class ProfilController {
    private final ProfilService profilService;
    private final SpecializareService specializareService;
    @PostMapping("/")
    public ResponseEntity<Profil> creeazaProfil(
            @RequestBody DateProfil dateProfil
    ) {
        return ResponseEntity.ok(profilService.creeazaProfil(dateProfil));
    }
    @GetMapping("/")
    public ResponseEntity<List<Profil>> getProfil() {
        return ResponseEntity.ok(profilService.toateProfilele());
    }
    @GetMapping("/{id}/specializari")
    public ResponseEntity<List<Specializare>> getSpecializari(@PathVariable Long id) {
        Optional<Profil> profil = profilService.findById(id);
        if (profil.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        List<Specializare> specializari = specializareService.extrageSpecializariProfil(profil.get());
        return ResponseEntity.ok(specializari);
    }
}
