package com.gpro.consulting.produit.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ElementTraitementValue {
    Long id;
    Long produitId;
    String dimension;
    String observation;
    Long machineId;
    String code;
    String nature;
    Double mesure;
    Double tolerancePlus;
    Double toleranceMoins;
}
