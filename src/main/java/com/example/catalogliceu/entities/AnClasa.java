package com.example.catalogliceu.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;

@Entity
@Table(name = "anclasa")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class AnClasa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Min(9)
    @Max(13)
    @Column(unique = true)
    private Long nrClasa;
}
