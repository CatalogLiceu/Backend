package com.example.catalogliceu.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "diriginte", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"clasa_id", "profesor_id"})
})
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Diriginte {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    private Clasa clasa;
    @OneToOne
    private Profesor profesor;
}