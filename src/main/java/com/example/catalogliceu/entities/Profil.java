package com.example.catalogliceu.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "profil")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Profil {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nume;
}
