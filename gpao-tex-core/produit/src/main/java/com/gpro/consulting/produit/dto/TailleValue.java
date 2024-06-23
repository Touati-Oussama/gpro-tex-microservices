package com.gpro.consulting.produit.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TailleValue {
    Long id;
    Long produitId;
    String designation;
    Integer ordre;
    String code;
}
