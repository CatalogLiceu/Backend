package com.example.catalogliceu.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "profesor")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Profesor extends Utilizator {
    @OneToMany(mappedBy = "profesor")
    private List<ClasaMaterieProfesor> clasaMaterieProfesori;
}
