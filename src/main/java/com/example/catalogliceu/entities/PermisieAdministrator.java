package com.example.catalogliceu.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "permisie_administrator", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"clasa_id", "liceu_id"})
})
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
    @JoinColumn(name = "utilizator_id")
    private Utilizator utilizator;
    @OneToOne
    @JoinColumn(name = "liceu_id")
    private Liceu liceu;

}