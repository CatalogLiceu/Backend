package com.example.catalogliceu.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "diriginte")
public class Diriginte extends Profesor {
    @OneToOne(mappedBy = "diriginte")
    private Clasa clasa;
}