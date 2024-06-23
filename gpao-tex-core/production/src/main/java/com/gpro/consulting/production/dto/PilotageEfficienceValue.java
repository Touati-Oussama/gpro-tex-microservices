package com.gpro.consulting.production.dto;

public record PilotageEfficienceValue(
        Long id,
        Long siteId,
        Long produitId,
        Double efficienceJour1,
        Double efficienceJour2,
        Double efficienceJour3,
        Double efficienceJour4,
        Double efficienceJour5,
        Double efficienceJour6,
        Double efficienceJour7
) {
}
