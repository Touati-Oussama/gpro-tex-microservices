package com.gpro.consulting.ordre.mapper;

import com.gpro.consulting.ordre.dto.DetailsColisageValue;
import com.gpro.consulting.ordre.model.DetailsColisage;
import com.gpro.consulting.ordre.model.FicheColisage;
import org.springframework.stereotype.Component;

@Component
public class DetailsColisageMapper {

    public DetailsColisage toEntity(DetailsColisageValue request) {
        if (request == null) {
            return null;
        }

        return DetailsColisage.builder()
                .id(request.getId())
                .ficheColisage(request.getFicheColisageId() != null ? FicheColisage.builder().id(request.getFicheColisageId()).build() : null)
                .couleurId(request.getCouleurId())
                .tailleId(request.getTailleId())
                .quantiteRestante(request.getQuantiteRestante())
                .quantite(request.getQuantite())
                .pcb(request.getPcb())
                .tailleDesignation(request.getTailleDesignation())
                .couleurDesignation(request.getCouleurDesignation())
                .poidsNet(request.getPoidsNet())
                .poidsBrut(request.getPoidsBrut())
                .choix(request.getChoix())
                .tailles(request.getTailles())
                .code(request.getCode())
                .codeCouleur(request.getCode())
                .quantiteDesignation(request.getQuantiteDesignation())
                .build();
    }

    public DetailsColisageValue toValue(DetailsColisage detailsColisage) {
        if (detailsColisage == null) {
            return null;
        }

        return new DetailsColisageValue(
                detailsColisage.getId(),
                detailsColisage.getFicheColisage() != null ? detailsColisage.getFicheColisage().getId() : null,
                detailsColisage.getCouleurId(),
                detailsColisage.getTailleId(),
                detailsColisage.getQuantiteRestante(),
                detailsColisage.getQuantite(),
                detailsColisage.getPcb(),
                detailsColisage.getTailleDesignation(),
                detailsColisage.getCouleurDesignation(),
                detailsColisage.getPoidsNet(),
                detailsColisage.getPoidsBrut(),
                detailsColisage.getChoix(),
                detailsColisage.getTailles(),
                detailsColisage.getCode(),
                detailsColisage.getCodeCouleur(),
                detailsColisage.getQuantiteDesignation()
        );
    }
}

