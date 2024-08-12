package com.example.catalogliceu.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DatePermisieAdministrator {
    private Long idLiceu;
    private Long idUtilizator;
}
