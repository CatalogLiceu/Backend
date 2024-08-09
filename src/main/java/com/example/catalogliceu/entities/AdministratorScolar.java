package com.example.catalogliceu.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "administrator_scolar")
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AdministratorScolar extends Utilizator {
}
