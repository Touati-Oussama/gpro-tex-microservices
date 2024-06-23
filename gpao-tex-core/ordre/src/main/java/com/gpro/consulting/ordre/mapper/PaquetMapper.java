package com.gpro.consulting.ordre.mapper;

import com.gpro.consulting.ordre.dto.PaquetValue;
import com.gpro.consulting.ordre.model.FicheEclatement;
import com.gpro.consulting.ordre.model.OrdreFabrication;
import com.gpro.consulting.ordre.model.Paquet;
import org.springframework.stereotype.Component;

@Component
public class PaquetMapper {
    public Paquet toEntity(PaquetValue request) {
        if (request == null) {
            return null;
        }

        return Paquet.builder()
                .id(request.getId())
                .ordreFabrication(OrdreFabrication.builder().id(request.getOrdreFabricationId()).build())
                .ficheEclatement(FicheEclatement.builder().id(request.getFicheEclatementId()).build())
                .num(request.getNum())
                .productionHeure(request.getProductionHeure())
                .siteId(request.getSiteId())
                .couleurId(request.getCouleurId())
                .tailleId(request.getTailleId())
                .quantite(request.getQuantite())
                .numMatelas(request.getNumMatelas())
                .numRouleaux(request.getNumRouleaux())
                .entreeDos(request.getEntreeDos())
                .sortieDos(request.getSortieDos())
                .entreeDevant(request.getEntreeDevant())
                .sortieDevant(request.getSortieDevant())
                .sortieAssemblage(request.getSortieAssemblage())
                .entreeAssemblage(request.getEntreeAssemblage())
                .entreeFinition(request.getEntreeFinition())
                .entreePreparation(request.getEntreePreparation())
                .sortiePreparation(request.getSortiePreparation())
                .engagement(request.getEngagement())
                .retrait(request.getRetrait())
                .build();
    }

    public PaquetValue toValue(Paquet paquet) {
        if (paquet == null) {
            return null;
        }

        return new PaquetValue(
                paquet.getId(),
                paquet.getOrdreFabrication() != null ? paquet.getOrdreFabrication().getId() : null,
                paquet.getFicheEclatement() != null ? paquet.getFicheEclatement().getId() : null,
                paquet.getNum(),
                paquet.getProductionHeure(),
                paquet.getSiteId(),
                paquet.getCouleurId(),
                paquet.getTailleId(),
                paquet.getQuantite(),
                paquet.getNumMatelas(),
                paquet.getNumRouleaux(),
                paquet.getEntreeDos(),
                paquet.getSortieDos(),
                paquet.getEntreeDos(),
                paquet.getSortieDevant(),
                paquet.getSortieAssemblage(),
                paquet.getEntreeAssemblage(),
                paquet.getEntreeFinition(),
                paquet.getEntreePreparation(),
                paquet.getSortiePreparation(),
                paquet.getEngagement(),
                paquet.getRetrait()
        );
    }
}

