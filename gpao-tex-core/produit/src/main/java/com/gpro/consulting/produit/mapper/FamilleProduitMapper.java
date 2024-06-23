package com.gpro.consulting.produit.mapper;

import com.gpro.consulting.produit.dto.FamilleProduitValue;
import com.gpro.consulting.produit.model.FamilleProduit;

public class FamilleProduitMapper {

    public static FamilleProduit toFamilleProduit(FamilleProduitValue value) {
        if (value == null) {
            return null;
        }

        FamilleProduit familleProduit = new FamilleProduit();
        familleProduit.setId(value.getId());
        familleProduit.setDesignation(value.getDesignation());
        familleProduit.setAchat(value.isAchat());
        familleProduit.setVente(value.isVente());

        return familleProduit;
    }

    public static FamilleProduitValue toFamilleProduitValue(FamilleProduit familleProduit) {
        if (familleProduit == null) {
            return null;
        }

        return new FamilleProduitValue(
                familleProduit.getId(),
                familleProduit.getDesignation(),
                familleProduit.isAchat(),
                familleProduit.isVente()
        );
    }
}

