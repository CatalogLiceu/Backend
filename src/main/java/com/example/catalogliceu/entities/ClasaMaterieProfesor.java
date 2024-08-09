package com.example.catalogliceu.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "clasa_materie_profesor")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ClasaMaterieProfesor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "clasa_id")
    private Clasa clasa;
    @ManyToOne
    @JoinColumn(name = "materie_id")
    private Materie materie;
    @ManyToOne
    @JoinColumn(name = "profesor_id")
    private Profesor profesor;
}
