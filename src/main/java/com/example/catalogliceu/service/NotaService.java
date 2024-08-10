package com.example.catalogliceu.service;

import com.example.catalogliceu.entities.Elev;
import com.example.catalogliceu.entities.Materie;
import com.example.catalogliceu.entities.Nota;
import com.example.catalogliceu.repositories.NotaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class NotaService {
    private final NotaRepository notaRepository;
    public NotaService(NotaRepository notaRepository) {
        this.notaRepository = notaRepository;
    }
    public void creeazaNota(Long valoare, Elev elev, Materie materie, LocalDate data) {
        Nota nota = Nota.builder()
                .valoare(valoare)
                .elev(elev)
                .materie(materie)
                .data(data)
                .build();
        notaRepository.save(nota);
    }
    public List<Nota> extrageNoteElev(Elev elev) {
        return notaRepository.findByElev(elev);
    }
}
