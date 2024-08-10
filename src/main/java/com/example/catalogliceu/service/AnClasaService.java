package com.example.catalogliceu.service;

import com.example.catalogliceu.entities.AnClasa;
import com.example.catalogliceu.repositories.AnClasaRepository;
import org.springframework.stereotype.Service;

@Service
public class AnClasaService {
    private final AnClasaRepository anClasaRepository;
    public AnClasaService(AnClasaRepository anClasaRepository) {
        this.anClasaRepository = anClasaRepository;
    }
    public void creeazaAn(Long nrClasa) {
        AnClasa anClasa = AnClasa.builder()
                .nrClasa(nrClasa)
                .build();
        anClasaRepository.save(anClasa);
    }
    public void stergeAn(Long nrClasa) {
        if(anClasaRepository.findById(nrClasa).isPresent()) {
            anClasaRepository.delete(anClasaRepository.findById(nrClasa).get());
        }
    }
    public void stergeAn(AnClasa anClasa) {
        if(anClasaRepository.findById(anClasa.getId()).isPresent()) {
            anClasaRepository.delete(anClasaRepository.findById(anClasa.getId()).get());
        }
    }
}
