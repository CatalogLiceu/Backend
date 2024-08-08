package com.example.catalogliceu.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@Entity
@Table(name = "anclasa")
public class AnClasa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Min(9)
    @Max(13)
    private Long nrClasa;
}
