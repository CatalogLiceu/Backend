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
    @OneToOne
    @JoinColumn(name = "profesor_id", nullable = false)
    private Profesor diriginte;
    private String litera;
    @OneToMany(mappedBy = "clasa")
    private List<Elev> elevi;
    @ManyToOne
    private Specializare specializare;
}
