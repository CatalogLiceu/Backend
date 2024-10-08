package com.example.catalogliceu.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CerereInregistrareAdministratorScolar {
    private DateUtilizator cerereInregistrareUtilizator;
    private Long idLiceu;
}
