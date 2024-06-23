package com.gpro.consulting.produit.mapper;

import com.gpro.consulting.produit.dto.LigneProduitValue;
import com.gpro.consulting.produit.model.LigneProduit;
import org.springframework.stereotype.Component;

@Component
public class LigneProduitMapper {

    public LigneProduit toLigneProduit(LigneProduitValue request) {
        if (request == null) {
            return null;
        }

        return LigneProduit.builder()
                .id(request.getId())
                .designation(request.getDesignation())
                .fournisseur(request.getFournisseur())
                .finDe(request.getFinDe())
                .finA(request.getFinA())
                .build();
    }

    public LigneProduitValue fromLigneProduit(LigneProduit ligneProduit) {
        if (ligneProduit == null) {
            return null;
        }

        return new LigneProduitValue(
                ligneProduit.getId(),
                ligneProduit.getDesignation(),
                ligneProduit.getFournisseur(),
                ligneProduit.getFinDe(),
                ligneProduit.getFinA()
        );
    }
}

