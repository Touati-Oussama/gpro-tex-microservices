package com.gpro.consulting.produit.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProduitValue {
    Long id;
    Long sousFamilleProduitId;
    Long siteId;
    Long themeId;
    Long ligneProduitId;
    List<ProduitGoshippementValue> produitGoShippements;
    List<MesureProduitValue> mesureProduits;
    List<TailleValue> tailles;
    List<CouleurValue> couleurs;
    List<PilotageEfficienceValue> pilotageEfficiences;
    List<ElementTraitementValue> elementTraitements;
    Long partieInteresseId;
    String reference;
    String designation;
    boolean ficheBesoin;
    boolean sansTaille;
    boolean sansCouleur;
    String codeConception;
    Integer quantite;
    Integer cadence;
    BigDecimal prixUnitaire;
    BigDecimal prixMajore;
    String etat;
    PartieInteresseValue partieInteresse;
}
