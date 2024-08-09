package com.example.catalogliceu.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "liceu")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Liceu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany
    private List<Specializare> specializari;
    private String nume;
    @OneToMany(mappedBy = "liceu")
    private List<Clasa> clase;
}
