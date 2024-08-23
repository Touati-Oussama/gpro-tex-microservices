package com.gpro.consulting.ordre.dto;

import java.math.BigDecimal;
import java.util.List;

public record ProduitValue(
        Long id,
        Long sousFamilleProduitId,
        Long siteId,
        Long themeId,
        Long ligneProduitId,
        List<ProduitGoshippementValue> produitGoShippements,
        List<MesureProduitValue> mesureProduits,
        List<TailleValue> tailles,
        List<CouleurValue> couleurs,
        List<PilotageEfficienceValue> pilotageEfficiences,
        List<ElementTraitementValue> elementTraitements,
        Long partieInteresseId,
        String reference,
        String designation,
        boolean ficheBesoin,
        boolean sansTaille,
        boolean sansCouleur,
        String codeConception,
        Integer quantite,
        Integer cadence,
        BigDecimal prixUnitaire,
        BigDecimal prixMajore,
        String etat
) {
}