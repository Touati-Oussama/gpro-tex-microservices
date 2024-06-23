package com.gpro.consulting.produit.mapper;

import com.gpro.consulting.produit.dto.MesureProduitValue;
import com.gpro.consulting.produit.model.MesureProduit;
import com.gpro.consulting.produit.model.Produit;
import com.gpro.consulting.produit.model.Taille;
import org.springframework.stereotype.Component;

@Component
public class MesureProduitMapper {

    public MesureProduit toMesureProduit(MesureProduitValue request) {
        if (request == null) {
            return null;
        }

        return MesureProduit.builder()
                .id(request.getId())
                .produit(request.getProduitId() != null ?
                        Produit.builder().id(request.getProduitId()).build() : null)
                .taille(request.getTailleId() != null ?
                        Taille.builder().id(request.getTailleId()).build() : null)
                .code(request.getCode())
                .mesure(request.getMesure())
                .tolerancePlus(request.getTolerancePlus())
                .toleranceMoins(request.getToleranceMoins())
                .build();
    }

    public MesureProduitValue fromMesureProduit(MesureProduit mesureProduit) {
        if (mesureProduit == null) {
            return null;
        }

        return new MesureProduitValue(
                mesureProduit.getId(),
                mesureProduit.getProduit().getId(),
                mesureProduit.getTaille().getId(),
                mesureProduit.getCode(),
                mesureProduit.getMesure(),
                mesureProduit.getTolerancePlus(),
                mesureProduit.getToleranceMoins()
        );
    }
}

