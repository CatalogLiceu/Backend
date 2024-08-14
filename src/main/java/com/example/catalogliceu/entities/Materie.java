package com.example.catalogliceu.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "materie")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Materie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToMany
    @JoinTable(
            name = "materie_specializare",
            joinColumns = @JoinColumn(name = "materie_id"),
            inverseJoinColumns = @JoinColumn(name = "specializare_id")
    )
    private List<Specializare> specializari;
    @ManyToMany
    @JoinTable(
            name = "materie_ani_clasa",
            joinColumns = @JoinColumn(name = "materie_id"),
            inverseJoinColumns = @JoinColumn(name = "an_clasa_id")
    )
    private List<AnClasa> aniClase;
    private String nume;
}
