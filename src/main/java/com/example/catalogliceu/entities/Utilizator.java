package com.example.catalogliceu.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "utilizator")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Utilizator {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    protected String nume;
    protected String prenume;
    @Column(unique = true)
    protected String email;
    @Column(unique = true)
    protected String porecla;
    protected String parola;
}
