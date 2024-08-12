package com.example.catalogliceu.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DateClasaMaterieProfesor {
    private Long idClasa;
    private Long idMaterie;
    private Long idProfesor;
}
