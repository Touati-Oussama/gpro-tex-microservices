package com.gpro.consulting.production.dto;

public record DetailOfValue(
        Long id,
        Long ordreId,
        Long pcb,
        Long tailleId,
        Long couleurId,
        String typeOrdre,
        String lieuLivraison,
        String dimension,
        String ue,
        String code,
        String codeCouleur,
        Double poidsNet,
        Double poidsBrut
) {
}
