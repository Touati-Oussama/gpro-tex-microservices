package com.gpro.consulting.produit.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetailsProduitValue {
    Long id;
    Long produitId;
    String code;
    Double poidsNet;
    Double poidsBrut;
    String description;
    String observations;
    Long pcb;
}
