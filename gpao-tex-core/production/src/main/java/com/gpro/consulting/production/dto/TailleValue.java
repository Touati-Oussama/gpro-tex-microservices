package com.gpro.consulting.production.dto;

public record TailleValue(
        Long id,
        Long produitId,
        String designation,
        Integer ordre,
        String code
) {
}
