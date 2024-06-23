package com.gpro.consulting.ordre.mapper;

import com.gpro.consulting.ordre.dto.ColisValue;
import com.gpro.consulting.ordre.model.Colis;
import com.gpro.consulting.ordre.model.FicheColisage;
import com.gpro.consulting.ordre.model.OrdreFabrication;
import org.springframework.stereotype.Component;

import java.util.Calendar;

@Component
public class ColisMapper {

    public Colis toEntity(ColisValue request) {
        if (request == null) {
            return null;
        }

        return Colis.builder()
                .id(request.getId())
                .ficheColisage(request.getFicheColisageId() != null ? FicheColisage.builder().id(request.getFicheColisageId()).build() : null)
                .ordre(request.getOrdreId() != null ? OrdreFabrication.builder().id(request.getOrdreId()).build() : null)
                .couleurId(request.getCouleurId())
                .tailleId(request.getTailleId())
                .siteId(request.getSiteId())
                .produitId(request.getProduitId())
                .tailles(request.getTailles())
                .quantite(request.getQuantite())
                .poidsNet(request.getPoidsNet())
                .poidsBrut(request.getPoidsBrut())
                .palette(request.getPalette())
                .dateSortie(request.getDateSortie() != null ? (Calendar) request.getDateSortie().clone() : null)
                .dateLancementDe(request.getDateLancementDe() != null ? (Calendar) request.getDateLancementDe().clone() : null)
                .dateLancementA(request.getDateLancementA() != null ? (Calendar) request.getDateLancementA().clone() : null)
                .build();
    }

    public ColisValue toValue(Colis colis) {
        if (colis == null) {
            return null;
        }

        return new ColisValue(
                colis.getId(),
                colis.getFicheColisage() != null ? colis.getFicheColisage().getId() : null,
                colis.getOrdre() != null ? colis.getOrdre().getId() : null,
                colis.getCouleurId(),
                colis.getTailleId(),
                colis.getSiteId(),
                colis.getProduitId(),
                colis.getTailles(),
                colis.getQuantite(),
                colis.getPoidsNet(),
                colis.getPoidsBrut(),
                colis.getPalette(),
                colis.getDateSortie() != null ? (Calendar) colis.getDateSortie().clone() : null,
                colis.getDateLancementDe() != null ? (Calendar) colis.getDateLancementDe().clone() : null,
                colis.getDateLancementA() != null ? (Calendar) colis.getDateLancementA().clone() : null
        );
    }
}
