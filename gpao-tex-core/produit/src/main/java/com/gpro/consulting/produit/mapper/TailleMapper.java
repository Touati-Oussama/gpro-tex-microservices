package com.gpro.consulting.produit.mapper;

import com.gpro.consulting.produit.dto.TailleValue;
import com.gpro.consulting.produit.model.Produit;
import com.gpro.consulting.produit.model.Taille;
import org.springframework.stereotype.Component;

@Component
public class TailleMapper {

    public Taille toTaille(TailleValue tailleValue) {
        if (tailleValue == null) {
            return null;
        }

        return Taille.builder()
                .id(tailleValue.getId())
                .produit(Produit.builder().id(tailleValue.getProduitId()).build())
                .designation(tailleValue.getDesignation())
                .ordre(tailleValue.getOrdre())
                .code(tailleValue.getCode())
                .build();
    }

    public TailleValue fromTaille(Taille taille) {
        if (taille == null) {
            return null;
        }

        return new TailleValue(
                taille.getId(),
                taille.getProduit().getId(),
                taille.getDesignation(),
                taille.getOrdre(),
                taille.getCode()
        );
    }
}


