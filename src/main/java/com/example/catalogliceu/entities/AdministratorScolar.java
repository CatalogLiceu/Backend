package com.example.catalogliceu.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "administrator_scolar")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AdministratorScolar extends Utilizator {
    @ManyToOne
    @JoinColumn(name = "liceu_id")
    private Liceu liceu;
    @Builder
    public AdministratorScolar(Long id, String nume, String prenume, String email, String porecla, String parola, Liceu liceu) {
        super(id, nume, prenume, email, porecla, parola);
        this.liceu = liceu;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(Rol.ROL_ADMINISTRATOR_SCOLAR.toString()));
    }
}
