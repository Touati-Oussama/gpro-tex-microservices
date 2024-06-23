package com.gpro.consulting.production.dto;

public record DocumentPiValue(
        Long id,
        Long partieInteresseId,
        String path,
        String uidDocument
) {
}
