package com.example.catalogliceu.controller;

import com.example.catalogliceu.dto.DateClasa;
import com.example.catalogliceu.dto.DateLiceu;
import com.example.catalogliceu.entities.Liceu;
import com.example.catalogliceu.entities.Specializare;
import com.example.catalogliceu.service.ClasaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clasa")
@RequiredArgsConstructor
public class ClasaController {

}
