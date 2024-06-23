package com.gpro.consulting.produit.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Calendar;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LigneProduitValue {
    Long id;
    String designation;
    Long fournisseur;
    Calendar finDe;
    Calendar finA;
}
