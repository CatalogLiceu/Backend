package com.example.catalogliceu.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "profesor")
public class Profesor extends Utilizator {
    @OneToMany
    private List<Materie> materii;
}
