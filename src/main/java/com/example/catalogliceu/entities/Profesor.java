package com.example.catalogliceu.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "profesor")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Profesor extends Utilizator {
    @Builder
    public Profesor(Long id, String nume, String prenume, String email, String porecla, String parola) {
        super(id, nume, prenume, email, porecla, parola);
    }
    @OneToMany(mappedBy = "profesor")
    private List<ClasaMaterieProfesor> clasaMaterieProfesori;
}
