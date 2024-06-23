package com.gpro.consulting.production.dto;

import java.util.Calendar;

public record LigneProduitValue(
        Long id,
        Long themeId,
        String designation,
        Long fournisseur,
        Calendar finDe,
        Calendar finA
) {
}
