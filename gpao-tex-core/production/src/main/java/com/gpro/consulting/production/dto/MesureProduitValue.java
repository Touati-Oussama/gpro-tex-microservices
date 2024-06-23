package com.gpro.consulting.production.dto;

public record MesureProduitValue(
        Long id,
        Long produitId,
        Long tailleId,
        String code,
        Double mesure,
        Double tolerancePlus,
        Double toleranceMoins
) {
}
