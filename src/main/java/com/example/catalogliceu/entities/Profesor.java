package com.example.catalogliceu.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "profesor")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Profesor extends Utilizator {
    @Builder
    public Profesor(Long id, String nume, String prenume, String email, String porecla, String parola) {
        super(id, nume, prenume, email, porecla, parola);
    }
    @OneToMany(mappedBy = "profesor")
    private List<ClasaMaterieProfesor> clasaMaterieProfesori;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(Rol.ROL_PROFESOR.toString()));
    }

}
