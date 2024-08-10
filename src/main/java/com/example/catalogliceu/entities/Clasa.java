package com.example.catalogliceu.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "clasa")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
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
    private String litera;
    @ManyToOne
    private Specializare specializare;
}
