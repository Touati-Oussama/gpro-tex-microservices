package com.gpro.consulting.production.dto;

public record PaquetValue(
        Long id,
        Long ordreFabricationId,
        Long ficheEclatementId,
        Long num,
        Boolean productionHeure,
        Long siteId,
        Long couleurId,
        Long tailleId,
        Long quantite,
        String numMatelas,
        String numRouleaux,
        Boolean entreeDos,
        Boolean sortieDos,
        Boolean entreeDevant,
        Boolean sortieDevant,
        Boolean sortieAssemblage,
        Boolean entreeAssemblage,
        Boolean entreeFinition,
        Boolean entreePreparation,
        Boolean sortiePreparation,
        Boolean engagement,
        String retrait
) {
}
