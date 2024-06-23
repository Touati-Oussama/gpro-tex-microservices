package com.gpro.consulting.ordre.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CouleurValue {
    Long id;
    Long produitId;
    String designation;
    String codeCouleur;
}
