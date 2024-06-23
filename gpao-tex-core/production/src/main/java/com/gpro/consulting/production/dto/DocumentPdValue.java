package com.gpro.consulting.production.dto;

public record DocumentPdValue(
        Long id,
        Long produitId,
        Long elementTraitementId,
        String path,
        String uidDocument,
        String description,
        String designation
) {
}
