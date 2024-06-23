package com.gpro.consulting.ordre.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PilotageEfficienceValue {
    Long id;
    Long siteId;
    Long produitId;
    Double efficienceJour1;
    Double efficienceJour2;
    Double efficienceJour3;
    Double efficienceJour4;
    Double efficienceJour5;
    Double efficienceJour6;
    Double efficienceJour7;
}
