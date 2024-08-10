package com.example.catalogliceu.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

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
