package com.gpro.consulting.production.dto;

import java.util.List;

public record ElementTraitementValue(
        Long id,
        Long produitId,
        List<DocumentPdValue> documents,
        String dimension,
        String observation,
        Long machineId,
        String code,
        String nature,
        Double mesure,
        Double tolerancePlus,
        Double toleranceMoins
) {
}
