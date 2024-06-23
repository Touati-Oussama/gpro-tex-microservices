package com.gpro.consulting.production.dto;

public record CapaciteSemaineValue(
        Long id,
        Long semaine,
        Long semainesDe,
        Long semainesA,
        Double capaciteTotale,
        Double capacitePrevisionnelle,
        Double nombreHeure,
        Double tauxAbsence,
        Long fin1,
        Long atelierId,
        Long annee
) {
}
