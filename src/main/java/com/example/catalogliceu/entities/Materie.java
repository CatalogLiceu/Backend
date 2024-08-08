package com.example.catalogliceu.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "materie")
public class Materie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany
    private List<Specializare> specializari;
    @OneToMany
    private List<AnClasa> clase;
    private String nume;
}
