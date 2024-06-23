package com.gpro.consulting.produit.mapper;

import com.gpro.consulting.produit.dto.ProduitGoshippementValue;
import com.gpro.consulting.produit.model.Produit;
import com.gpro.consulting.produit.model.ProduitGoShippement;
import com.gpro.consulting.produit.model.Site;
import org.springframework.stereotype.Component;

@Component
public class ProduitGoShippementMapper {

    public ProduitGoShippement toProduitGoShippement(ProduitGoshippementValue request) {
        if (request == null) {
            return null;
        }

        return ProduitGoShippement.builder()
                .id(request.getId())
                .site(request.getSiteId() != null ?
                        Site.builder().id(request.getSiteId()).build() : null)
                .produit(request.getProduitId() != null ?
                        Produit.builder().id(request.getProduitId()).build() : null)
                .saison(request.getSaison())
                .goShippement(request.getGoShippement())
                .build();
    }

    public ProduitGoshippementValue fromProduitGoShippement(ProduitGoShippement produitGoShippement) {
        if (produitGoShippement == null) {
            return null;
        }

        return new ProduitGoshippementValue(
                produitGoShippement.getId(),
                produitGoShippement.getSite().getId(),
                produitGoShippement.getProduit().getId(),
                produitGoShippement.getSaison(),
                produitGoShippement.getGoShippement()
        );
    }
}

