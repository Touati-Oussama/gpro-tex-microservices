package com.gpro.consulting.ordre.mapper;

import com.gpro.consulting.ordre.dto.FicheEclatementValue;
import com.gpro.consulting.ordre.model.FicheEclatement;
import com.gpro.consulting.ordre.model.OrdreFabrication;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class FicheEclatementMapper {
    private final PaquetMapper paquetMapper;
    private final ChaineMapper chaineMapper;

    public FicheEclatement toEntity(FicheEclatementValue request) {
        if (request == null) {
            return null;
        }

        return FicheEclatement.builder()
                .id(request.getId())
                .paquets(request.getPaquets().stream().map(paquetMapper::toEntity).collect(Collectors.toList()))
                .chaines(request.getChaines().stream().map(chaineMapper::toEntity).collect(Collectors.toList()))
                .ordreFabrication(OrdreFabrication.builder().id(request.getOrdreId()).build())
                .dateLancement(request.getDateLancement())
                .observations(request.getObservations())
                .nombrePaquet(request.getNombrePaquet())
                .quantiteEclate(request.getQuantiteEclate())
                .codeConception(request.getCodeConception())
                .clientAbreviation(request.getClientAbreviation())
                .produitId(request.getProduitId())
                .build();
    }

    public FicheEclatementValue toValue(FicheEclatement ficheEclatement) {
        if (ficheEclatement == null) {
            return null;
        }

        return new FicheEclatementValue(
                ficheEclatement.getId(),
                ficheEclatement.getPaquets().stream().map(paquetMapper::toValue).collect(Collectors.toList()),
                ficheEclatement.getChaines().stream().map(chaineMapper::toValue).collect(Collectors.toList()),
                ficheEclatement.getOrdreFabrication() != null ? ficheEclatement.getOrdreFabrication().getId() : null,
                ficheEclatement.getDateLancement(),
                ficheEclatement.getObservations(),
                ficheEclatement.getNombrePaquet(),
                ficheEclatement.getQuantiteEclate(),
                ficheEclatement.getCodeConception(),
                ficheEclatement.getClientAbreviation(),
                ficheEclatement.getProduitId()
        );
    }
}
