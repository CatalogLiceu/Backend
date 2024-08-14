package com.example.catalogliceu.service;

import com.example.catalogliceu.dto.CerereSchimbareNumePrenumeUtilizator;
import com.example.catalogliceu.entities.Utilizator;
import com.example.catalogliceu.repositories.UtilizatorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public Utilizator schimbaNumeUtilizator(Utilizator utilizator, CerereSchimbareNumePrenumeUtilizator cerereSchimbareNumePrenumeUtilizator) {
        utilizator.setNume(cerereSchimbareNumePrenumeUtilizator.getNume());
        utilizator.setPrenume(cerereSchimbareNumePrenumeUtilizator.getPrenume());
        utilizator = utilizatorRepository.save(utilizator);
        return utilizator;
    }
    public List<Utilizator> totiUtilizatorii() {
        return utilizatorRepository.findAll();
    }
}
