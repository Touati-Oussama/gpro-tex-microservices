package com.gpro.consulting.ordre.mapper;

import com.gpro.consulting.ordre.dto.DetailOfValue;
import com.gpro.consulting.ordre.model.DetailOf;
import com.gpro.consulting.ordre.model.OrdreFabrication;
import org.springframework.stereotype.Component;

@Component
public class DetailOfMapper {

    public DetailOf toDetailOf(DetailOfValue request) {
        if (request == null) {
            return null;
        }
        return DetailOf.builder()
                .id(request.getId())
                .quantite(request.getQuantite())
                .ordre(request.getOrdreId() != null ?
                        OrdreFabrication.builder().id(request.getOrdreId()).build() : null)
                .pcb(request.getPcb())
                .tailleId(request.getTailleId())
                .couleurId(request.getCouleurId())
                .typeOrdre(request.getTypeOrdre())
                .lieuLivraison(request.getLieuLivraison())
                .dimension(request.getDimension())
                .ue(request.getUe())
                .code(request.getCode())
                .codeCouleur(request.getCode())
                .poidsNet(request.getPoidsNet())
                .poidsBrut(request.getPoidsBrut())
                .qteRecuCoupe(request.getQteRecuCoupe())
                .qtePreteCoupe(request.getQtePreteCoupe())
                .qtePriseProd(request.getQtePriseProd())
                .qtePriseCoupe(request.getQtePriseCoupe())
                .qteRecueProd(request.getQteRecueProd())
                .qteProduite(request.getQteProduite())
                .build();
    }

    public DetailOfValue fromDetailOf(DetailOf detailOf) {
        if (detailOf == null) {
            return null;
        }
        return new DetailOfValue(
                detailOf.getId(),
                detailOf.getQuantite(),
                detailOf.getOrdre() != null ? detailOf.getOrdre().getId() : null,
                detailOf.getPcb(),
                detailOf.getTailleId(),
                detailOf.getCouleurId(),
                detailOf.getTypeOrdre(),
                detailOf.getLieuLivraison(),
                detailOf.getDimension(),
                detailOf.getUe(),
                detailOf.getCode(),
                detailOf.getCodeCouleur(),
                detailOf.getPoidsNet(),
                detailOf.getPoidsBrut(),
                detailOf.getQteRecuCoupe(),
                detailOf.getQtePreteCoupe(),
                detailOf.getQtePriseProd(),
                detailOf.getQtePriseCoupe(),
                detailOf.getQteRecueProd(),
                detailOf.getQteProduite()
        );
    }
}
