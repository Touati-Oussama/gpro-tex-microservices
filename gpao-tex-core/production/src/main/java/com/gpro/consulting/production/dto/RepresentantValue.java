package com.gpro.consulting.production.dto;

public record RepresentantValue(
        Long id,
        String nom,
        String fonction,
        String email,
        String telephone,
        String fax,
        Long partieInteresseId
) {
}
