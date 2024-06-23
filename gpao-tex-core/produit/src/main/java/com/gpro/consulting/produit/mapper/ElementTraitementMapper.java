package com.gpro.consulting.produit.mapper;

import com.gpro.consulting.produit.dto.ElementTraitementValue;
import com.gpro.consulting.produit.model.ElementTraitement;
import com.gpro.consulting.produit.model.Produit;
import org.springframework.stereotype.Component;

@Component
public class ElementTraitementMapper {

    public ElementTraitement toElementTraitement(ElementTraitementValue request) {
        if (request == null) {
            return null;
        }

        return ElementTraitement.builder()
                .id(request.getId())
                .produit(request.getProduitId() != null ?
                        Produit.builder().id(request.getProduitId()).build() : null)
                .dimension(request.getDimension())
                .observation(request.getObservation())
                .machineId(request.getMachineId())
                .code(request.getCode())
                .nature(request.getNature())
                .mesure(request.getMesure())
                .tolerancePlus(request.getTolerancePlus())
                .toleranceMoins(request.getToleranceMoins())
                .build();
    }

    public ElementTraitementValue fromElementTraitement(ElementTraitement elementTraitement) {
        if (elementTraitement == null) {
            return null;
        }

        return new ElementTraitementValue(
                elementTraitement.getId(),
                elementTraitement.getProduit().getId(),
                elementTraitement.getDimension(),
                elementTraitement.getObservation(),
                elementTraitement.getMachineId(),
                elementTraitement.getCode(),
                elementTraitement.getNature(),
                elementTraitement.getMesure(),
                elementTraitement.getTolerancePlus(),
                elementTraitement.getToleranceMoins()
        );
    }
}

