package com.example.catalogliceu.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "clasa")
public class Clasa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "liceu_id", nullable = false)
    private Liceu liceu;
    @ManyToOne
    @JoinColumn(name = "anclasa_id", nullable = false)
    private AnClasa anClasa;
    @OneToOne
    @JoinColumn(name = "diriginte_id", nullable = false)
    private Diriginte diriginte;
    private String litera;
    @OneToMany(mappedBy = "clasa")
    private List<Elev> elevi;
    @ManyToOne
    private Specializare specializare;
}
