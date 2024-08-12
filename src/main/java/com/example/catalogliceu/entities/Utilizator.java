package com.example.catalogliceu.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "utilizator")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Utilizator implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    protected String nume;
    protected String prenume;
    @Column(unique = true)
    protected String email;
    @Column(unique = true)
    protected String porecla;
    protected String parola;
    @Override
    public String getUsername() {
        return getPorecla();
    }
    @Override
    public String getPassword() {
        return getParola();
    }
}
