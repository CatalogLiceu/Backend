package com.example.catalogliceu.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CerereSchimbareNumePrenumeUtilizator {
    private String nume;
    private String prenume;
}
