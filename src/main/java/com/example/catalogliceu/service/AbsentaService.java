package com.example.catalogliceu.service;

import com.example.catalogliceu.entities.Absenta;
import com.example.catalogliceu.entities.Elev;
import com.example.catalogliceu.entities.Materie;
import com.example.catalogliceu.repositories.AbsentaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AbsentaService {
    private final AbsentaRepository absentaRepository;
    public AbsentaService(AbsentaRepository absentaRepository) {
        this.absentaRepository = absentaRepository;
    }
    public void creeazaAbsenta(Elev elev, Materie materie, LocalDate data) {
        Absenta absenta = Absenta.builder()
                .elev(elev)
                .materie(materie)
                .data(data)
                .build();
        absentaRepository.save(absenta);
    }
}
