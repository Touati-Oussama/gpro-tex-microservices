package com.gpro.consulting.produit.mapper;

import com.gpro.consulting.produit.dto.SousFamilleValue;
import com.gpro.consulting.produit.model.FamilleProduit;
import com.gpro.consulting.produit.model.SousFamilleProduit;
import org.springframework.stereotype.Component;

@Component
public class SousFamilleMapper {

    public SousFamilleProduit toSousFamilleProduit(SousFamilleValue request) {
        if (request == null) {
            return null;
        }

        return SousFamilleProduit.builder()
                .id(request.getId())
                .familleProduit(request.getFamilleProduitId() != null ?
                        FamilleProduit.builder().id(request.getFamilleProduitId()).build() : null)
                .designation(request.getDesignation())
                .build();
    }

    public SousFamilleValue fromSousFamilleProduit(SousFamilleProduit sousFamilleProduit) {
        if (sousFamilleProduit == null) {
            return null;
        }

        return new SousFamilleValue(
                sousFamilleProduit.getId(),
                sousFamilleProduit.getFamilleProduit().getId(),
                sousFamilleProduit.getDesignation()
        );
    }
}
