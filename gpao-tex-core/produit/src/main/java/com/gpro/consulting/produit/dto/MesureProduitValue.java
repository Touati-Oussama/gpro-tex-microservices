package com.gpro.consulting.produit.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MesureProduitValue {
    Long id;
    Long produitId;
    Long tailleId;
    String code;
    Double mesure;
    Double tolerancePlus;
    Double toleranceMoins;
}
