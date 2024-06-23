package com.gpro.consulting.production.dto;

public record CouleurValue(
        Long id,
        Long produitId,
        String designation,
        String codeCouleur
) {
}
