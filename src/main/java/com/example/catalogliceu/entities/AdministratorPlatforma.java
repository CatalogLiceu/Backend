package com.example.catalogliceu.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "administrator_platforma")
@NoArgsConstructor
@Getter
@Setter
public class AdministratorPlatforma extends Utilizator {
    @Builder
    public AdministratorPlatforma(Long id, String nume, String prenume, String email, String porecla, String parola) {
        super(id, nume, prenume, email, porecla, parola);
    }
    @Transient
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(Rol.ROL_ADMINISTRATOR_PLATFORMA.toString()));
    }
}
