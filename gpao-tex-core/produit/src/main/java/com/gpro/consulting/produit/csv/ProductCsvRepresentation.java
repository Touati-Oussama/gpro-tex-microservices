package com.gpro.consulting.produit.csv;

import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductCsvRepresentation {
    @CsvBindByName(column = "id")
    private Long id;
    @CsvBindByName(column = "partieInteresseId")
    private Long partieInteresseId;
    @CsvBindByName(column = "reference")
    private String reference;
    @CsvBindByName(column = "designation")
    private String designation;
    @CsvBindByName(column = "ficheBesoin")
    private boolean ficheBesoin;
    @CsvBindByName(column = "sansTaille")
    private boolean sansTaille;
    @CsvBindByName(column = "sansCouleur")
    private boolean sansCouleur;
    @CsvBindByName(column = "codeConception")
    private String codeConception;
    @CsvBindByName(column = "quantite")
    private Integer quantite;
    private @CsvBindByName(column = "prixUnitaire")
    BigDecimal prixUnitaire;


}
