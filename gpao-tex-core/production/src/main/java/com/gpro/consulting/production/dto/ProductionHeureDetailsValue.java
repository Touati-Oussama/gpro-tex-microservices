package com.gpro.consulting.production.dto;

import java.util.Calendar;

public record ProductionHeureDetailsValue(
        Long id,
        Long productionHeureId,
        Long detailsId,
        Double qteFinie,
        Double qteNonEmballe,
        Double qteRetouche,
        Double qteDeuxiemeChoix,
        Long nbreColis,
        Calendar date,
        Long numPaquet,
        Long paquetId,
        Long colisId,
        Boolean complement,
        Long quantite,
        String operation,
        String observations,
        Long tailleId,
        Long couleurId,
        Long ordrePaquet,
        String numMatelasPaquet,
        String nature
) {
}
