package com.example.catalogliceu.service;

import com.example.catalogliceu.dto.DateAnClasa;
import com.example.catalogliceu.entities.AnClasa;
import com.example.catalogliceu.entities.Specializare;
import com.example.catalogliceu.exceptions.AnClasaInexistentException;
import com.example.catalogliceu.exceptions.SpecializareInexistentaException;
import com.example.catalogliceu.repositories.AnClasaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AnClasaService {
    private final AnClasaRepository anClasaRepository;
    public AnClasaService(AnClasaRepository anClasaRepository) {
        this.anClasaRepository = anClasaRepository;
    }
    public AnClasa creeazaAn(DateAnClasa dateAnClasa) {
        AnClasa anClasa = AnClasa.builder()
                .nrClasa(dateAnClasa.getNrClasa())
                .build();
        anClasa = anClasaRepository.save(anClasa);
        return anClasa;
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
    public List<AnClasa> getAniClase() {
        return anClasaRepository.findAll();
    }
    public Optional<AnClasa> dupaId(Long id) {
        return anClasaRepository.findById(id);
    }
    public List<AnClasa> aniClasaDupaId(List<Long> id) {
        List<AnClasa> aniClasa = new ArrayList<>();
        for(Long it : id) {
            Optional<AnClasa> anClasa = anClasaRepository.findById(it);
            if(anClasa.isEmpty()) {
                throw new AnClasaInexistentException("Nu exista an clasa cu id: " + it);
            }
            aniClasa.add(anClasa.get());
        }
        return aniClasa;
    }
}
