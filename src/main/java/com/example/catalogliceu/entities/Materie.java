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
    @OneToMany
    private List<AnClasa> clase;
    private String nume;
}
