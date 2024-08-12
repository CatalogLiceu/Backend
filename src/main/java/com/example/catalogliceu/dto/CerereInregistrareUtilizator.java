package com.example.catalogliceu.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CerereInregistrareUtilizator {
    private String nume;
    private String prenume;
    private String porecla;
    private String email;
    private String parola;
}
