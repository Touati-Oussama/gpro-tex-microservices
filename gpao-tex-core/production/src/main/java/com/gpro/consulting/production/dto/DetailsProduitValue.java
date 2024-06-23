package com.gpro.consulting.production.dto;

public record DetailsProduitValue(
        Long id,
        Long produitId,
        String code,
        Double poidsNet,
        Double poidsBrut,
        String description,
        String observations,
        Long pcb
) {
}
