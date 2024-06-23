package com.gpro.consulting.production.dto;

import java.util.Calendar;
import java.util.List;

public record ProductionHeureValue(
        Long id,
        Calendar date,
        Long quantite,
        String observation,
        Long elementPlanningId,
        Long ofId,
        Long chaineId,
        Long partieInterreseId,
        Long produitId,
        String periode,
        List<ProductionHeureDetailsValue> productionHeureDetails
) {
}
