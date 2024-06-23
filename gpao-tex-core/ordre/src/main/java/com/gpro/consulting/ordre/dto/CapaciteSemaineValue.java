package com.gpro.consulting.ordre.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CapaciteSemaineValue {
    Long id;
    Long semaine;
    Long semainesDe;
    Long semainesA;
    Double capaciteTotale;
    Double capacitePrevisionnelle;
    Double nombreHeure;
    Double tauxAbsence;
    Long fin1;
    Long atelierId;
    Long annee;
}
