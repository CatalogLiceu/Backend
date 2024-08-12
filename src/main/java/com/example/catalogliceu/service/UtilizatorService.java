package com.example.catalogliceu.service;

import com.example.catalogliceu.entities.Utilizator;
import com.example.catalogliceu.repositories.UtilizatorRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UtilizatorService {
    private final UtilizatorRepository utilizatorRepository;
    public UtilizatorService(UtilizatorRepository utilizatorRepository) {
        this.utilizatorRepository = utilizatorRepository;
    }
    public Optional<Utilizator> dupaId(Long id) {
        return utilizatorRepository.findById(id);
    }
}
