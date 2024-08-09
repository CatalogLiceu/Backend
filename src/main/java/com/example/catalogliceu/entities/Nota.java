package com.example.catalogliceu.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "nota")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Nota {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Min(1)
    @Max(10)
    private Long valoare;
    @ManyToOne
    private Elev elev;
    @ManyToOne
    private Materie materie;
    private LocalDate data;
}
