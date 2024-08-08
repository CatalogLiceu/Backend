package com.example.catalogliceu.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "utilizator")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Utilizator {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nume;
    private String prenume;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String porecla;
    private String parola;
}
