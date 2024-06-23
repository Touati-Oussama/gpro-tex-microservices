package com.gpro.consulting.ordre.mapper;

import com.gpro.consulting.ordre.dto.ChaineValue;
import com.gpro.consulting.ordre.model.Chaine;
import com.gpro.consulting.ordre.model.FicheEclatement;
import com.gpro.consulting.ordre.model.OrdreFabrication;
import org.springframework.stereotype.Component;

@Component
public class ChaineMapper {
    public Chaine toEntity(ChaineValue request) {
        if (request == null) {
            return null;
        }

        return Chaine.builder()
                .id(request.getId())
                .ficheEclatement(FicheEclatement.builder().id(request.getFicheEclatementId()).build())
                .ordre(OrdreFabrication.builder().id(request.getOrdreId()).build())
                .designation(request.getDesignation())
                .siteId(request.getSiteId())
                .dateLibre(request.getDateLibre())
                .planning(request.isPlanning())
                .designationClient(request.getDesignationClient())
                .production(request.getProduction())
                .developpement(request.getDeveloppement())
                .posteQualite1(request.getPosteQualite1())
                .defaut1(request.getDefaut1())
                .nbDefaut1(request.getNbDefaut1())
                .build();
    }

    public ChaineValue toValue(Chaine chaine) {
        if (chaine == null) {
            return null;
        }

        return new ChaineValue(
                chaine.getId(),
                chaine.getFicheEclatement() != null ? chaine.getFicheEclatement().getId() : null,
                chaine.getOrdre() != null ? chaine.getOrdre().getId() : null,
                chaine.getDesignation(),
                chaine.getSiteId(),
                chaine.getDateLibre(),
                chaine.isPlanning(),
                chaine.getDesignationClient(),
                chaine.getProduction(),
                chaine.getDeveloppement(),
                chaine.getPosteQualite1(),
                chaine.getDefaut1(),
                chaine.getNbDefaut1()
        );
    }
}
