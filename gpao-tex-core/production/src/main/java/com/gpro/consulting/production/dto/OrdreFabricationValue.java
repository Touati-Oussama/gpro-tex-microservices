package com.gpro.consulting.production.dto;

import java.util.Calendar;
import java.util.Set;

public record OrdreFabricationValue(
        Long id,
        Long chaineId,
        Set<DetailOfValue> detailOfValues,
        Integer quantite,
        Long produitId,
        Calendar dateDebut,
        Calendar dateFin,
        String priorite,
        String status,
        String informationsStock,
        Integer qtCoupe,
        Integer qtEngagement,
        Integer qtSortie,
        Integer qtFinition,
        Integer qtColisage,
        Integer qtExpedition,
        Integer qtePriseProd,
        Integer qteRecueProd,
        Integer qtePriseCoupe,
        Integer qteRecuCoupe,
        Long qteEntreeAssemblage,
        Long qteSortieAssemblage,
        Long qteEntreeFinition,
        Long qteEntreePreparation,
        Long qteSortiePreparation
) {
}
