package com.example.catalogliceu.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "elev")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Elev extends Utilizator {
    @ManyToOne
    @JoinColumn(name = "clasa_id", nullable = false)
    private Clasa clasa;
}
