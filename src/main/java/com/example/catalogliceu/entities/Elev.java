package com.example.catalogliceu.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "elev")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Elev extends Utilizator {
    @ManyToOne
    @JoinColumn(name = "clasa_id")
    private Clasa clasa;
    @Builder
    public Elev(Long id, String nume, String prenume, String email, String porecla, String parola, Clasa clasa) {
        super(id, nume, prenume, email, porecla, parola);
        this.clasa = clasa;
    }
}
