package com.example.catalogliceu.service;

import com.example.catalogliceu.dto.DateUtilizator;
import com.example.catalogliceu.entities.Clasa;
import com.example.catalogliceu.entities.Elev;
import com.example.catalogliceu.entities.Utilizator;
import com.example.catalogliceu.repositories.ElevRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ElevService {
    private final ElevRepository elevRepository;
    private final PasswordEncoder passwordEncoder;
    public ElevService(ElevRepository elevRepository, PasswordEncoder passwordEncoder) {
        this.elevRepository = elevRepository;
        this.passwordEncoder = passwordEncoder;
    }
    public Elev creeazaElev(DateUtilizator dateUtilizator, Clasa clasa) {
        Elev elev = Elev.builder()
                .nume(dateUtilizator.getNume())
                .prenume(dateUtilizator.getPrenume())
                .email(dateUtilizator.getEmail())
                .porecla(dateUtilizator.getPorecla())
                .parola(passwordEncoder.encode(dateUtilizator.getParola()))
                .clasa(clasa)
                .build();
        elev = elevRepository.save(elev);
        return elev;
    }

    public Boolean esteElev(Utilizator utilizator) {
        return elevRepository.findByPorecla(utilizator.getPorecla()).isPresent();
    }
    public List<Elev> extrageDupaClasa(Clasa clasa) {
        return elevRepository.findByClasa(clasa);
    }
    public Optional<Elev> dupaId(Long id) {
        return elevRepository.findById(id);
    }
}
