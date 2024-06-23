package com.gpro.consulting.production.dto;

public record ProduitGoshippementValue(
        Long id,
        Long siteId,
        Long produitId,
        String saison,
        String goShippement
) {
}
