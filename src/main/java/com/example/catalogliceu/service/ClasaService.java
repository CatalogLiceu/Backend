package com.example.catalogliceu.service;

import com.example.catalogliceu.entities.AnClasa;
import com.example.catalogliceu.entities.Clasa;
import com.example.catalogliceu.entities.Liceu;
import com.example.catalogliceu.entities.Specializare;
import com.example.catalogliceu.repositories.ClasaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClasaService {
    private final ClasaRepository clasaRepository;
    public ClasaService(ClasaRepository clasaRepository) {
        this.clasaRepository = clasaRepository;
    }
    public Clasa creeazaClasa(Liceu liceu, AnClasa anClasa, String litera, Specializare specializare) {
        Clasa clasa = Clasa.builder()
                .liceu(liceu)
                .anClasa(anClasa)
                .litera(litera)
                .specializare(specializare)
                .build();
        clasa = clasaRepository.save(clasa);
        return clasa;
    }
    public List<Clasa> extrageDupaLiceu(Liceu liceu) {
        return clasaRepository.findByLiceu(liceu);
    }
    public Optional<Clasa> dupaId(Long id) {
        return clasaRepository.findById(id);
    }
}
