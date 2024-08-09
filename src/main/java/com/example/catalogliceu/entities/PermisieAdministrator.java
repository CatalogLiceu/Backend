package com.example.catalogliceu.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "permisie_administrator")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class PermisieAdministrator {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    @JoinColumn(name = "utilizator_id", unique = true)
    private Utilizator utilizator;
}