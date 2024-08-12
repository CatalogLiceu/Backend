package com.example.catalogliceu.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DateNota {
    private Long valoare;
    private LocalDate data;
    private Long idElev;
    private Long idMaterie;
}
