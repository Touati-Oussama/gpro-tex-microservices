package com.gpro.consulting.production.dto;

import java.util.Calendar;

public record ColisValue(
        Long id,
        Long ficheColisageId,
        Long ordreId,
        Long couleurId,
        Long tailleId,
        Long siteId,
        Long produitId,
        String tailles,
        Long quantite,
        Double poidsNet,
        Double poidsBrut,
        String palette,
        Calendar dateSortie,
        Calendar dateLancementDe,
        Calendar dateLancementA
) {
}
