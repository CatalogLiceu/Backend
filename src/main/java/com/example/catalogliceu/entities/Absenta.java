package com.example.catalogliceu.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "absenta")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Absenta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Elev elev;
    @ManyToOne
    private Materie materie;
    private LocalDate data;
}
