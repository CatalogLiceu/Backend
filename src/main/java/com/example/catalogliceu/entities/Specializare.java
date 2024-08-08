package com.example.catalogliceu.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "specializare")
public class Specializare {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "profil_id", nullable = false)
    private Profil profil;
    private String nume;
}
