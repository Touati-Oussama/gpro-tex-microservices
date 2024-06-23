package com.gpro.consulting.ordre.mapper;

import com.gpro.consulting.ordre.dto.FicheColisageValue;
import com.gpro.consulting.ordre.model.FicheColisage;
import com.gpro.consulting.ordre.model.OrdreFabrication;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Collections;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class FicheColisageMapper {
    private ColisMapper colisMapper;
    private DetailsColisageMapper detailsColisageMapper;

    public FicheColisage toEntity(FicheColisageValue request) {
        if (request == null) {
            return null;
        }

        return FicheColisage.builder()
                .id(request.getId())
                .ordre(request.getOrderId() != null ? OrdreFabrication.builder().id(request.getOrderId()).build() : null)
                .colis(request.getColis() != null ?
                        request.getColis().stream().map(colisMapper::toEntity).collect(Collectors.toList()) :
                        Collections.emptyList())
                .detailsColisages(request.getDetailsColisages() != null ?
                        request.getDetailsColisages().stream().map(detailsColisageMapper::toEntity).collect(Collectors.toList()) :
                        Collections.emptyList())
                .observations(request.getObservations())
                .nombreColis(request.getNombreColis())
                .quantiteColis(request.getQuantiteColis())
                .numeroOf(request.getNumeroOf())
                .quantiteTotale(request.getQuantiteTotale())
                .produitId(request.getProduitId())
                .clientId(request.getClientId())
                .clientAbreviation(request.getClientAbreviation())
                .clientReference(request.getClientReference())
                .couleur(request.getCouleur())
                .produitDesignationInfo1(request.getProduitDesignationInfo1())
                .numeroInterne(request.getNumeroInterne())
                .dateDe(request.getDateDe() != null ? (Calendar) request.getDateDe().clone() : null)
                .dateA(request.getDateA() != null ? (Calendar) request.getDateA().clone() : null)
                .build();
    }

    public FicheColisageValue toValue(FicheColisage ficheColisage) {
        if (ficheColisage == null) {
            return null;
        }

        return new FicheColisageValue(
                ficheColisage.getId(),
                ficheColisage.getOrdre() != null ? ficheColisage.getOrdre().getId() : null,
                ficheColisage.getColis() != null ? ficheColisage.getColis()
                        .stream().map(colisMapper::toValue).collect(Collectors.toList()) :
                        Collections.emptyList(),
                ficheColisage.getDetailsColisages() != null ? ficheColisage.getDetailsColisages()
                        .stream().map(detailsColisageMapper::toValue).collect(Collectors.toList()) :
                        Collections.emptyList(),
                ficheColisage.getObservations(),
                ficheColisage.getNombreColis(),
                ficheColisage.getQuantiteColis(),
                ficheColisage.getNumeroOf(),
                ficheColisage.getQuantiteTotale(),
                ficheColisage.getProduitId(),
                ficheColisage.getClientId(),
                ficheColisage.getClientAbreviation(),
                ficheColisage.getClientReference(),
                ficheColisage.getCouleur(),
                ficheColisage.getProduitDesignationInfo1(),
                ficheColisage.getNumeroInterne(),
                ficheColisage.getDateDe() != null ? (Calendar) ficheColisage.getDateDe().clone() : null,
                ficheColisage.getDateA() != null ? (Calendar) ficheColisage.getDateA().clone() : null
        );
    }
}
