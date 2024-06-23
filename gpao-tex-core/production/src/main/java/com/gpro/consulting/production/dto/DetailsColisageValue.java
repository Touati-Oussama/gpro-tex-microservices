package com.gpro.consulting.production.dto;

public record DetailsColisageValue(
        Long id,
        Long ficheColisageId,
        Long couleurId,
        Long tailleId,
        Long quantiteRestante,
        Long quantite,
        Long pcb,
        String tailleDesignation,
        String couleurDesignation,
        Double poidsNet,
        Double poidsBrut,
        String choix,
        String tailles,
        String code,
        String codeCouleur,
        String quantiteDesignation
) {
}
