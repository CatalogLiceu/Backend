package com.example.catalogliceu.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DateUtilizator {
    private String nume;
    private String prenume;
    private String email;
    private String porecla;
    private String parola;
}
