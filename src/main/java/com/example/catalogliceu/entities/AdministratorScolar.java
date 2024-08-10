package com.example.catalogliceu.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "administrator_scolar")
@NoArgsConstructor
@Getter
@Setter
public class AdministratorScolar extends Utilizator {
    @Builder
    public AdministratorScolar(Long id, String nume, String prenume, String email, String porecla, String parola, Clasa clasa) {
        super(id, nume, prenume, email, porecla, parola);
    }
}
