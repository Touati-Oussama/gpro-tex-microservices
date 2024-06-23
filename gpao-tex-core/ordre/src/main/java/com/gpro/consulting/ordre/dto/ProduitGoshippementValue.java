package com.gpro.consulting.ordre.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProduitGoshippementValue {
    Long id;
    Long siteId;
    Long produitId;
    String saison;
    String goShippement;
}
