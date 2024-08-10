package com.example.catalogliceu.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "specializare")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Specializare {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "profil_id", nullable = false)
    private Profil profil;
    private String nume;
}
