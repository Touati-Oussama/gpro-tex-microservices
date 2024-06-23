package com.gpro.consulting.production.dto;

public record FamilleProduitValue(
        Long id,
        String designation,
        boolean achat,
        boolean vente
) {
}
