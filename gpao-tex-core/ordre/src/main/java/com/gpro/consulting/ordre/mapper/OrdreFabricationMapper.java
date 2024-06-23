package com.gpro.consulting.ordre.mapper;

import com.gpro.consulting.ordre.dto.OrdreFabricationValue;
import com.gpro.consulting.ordre.model.Chaine;
import com.gpro.consulting.ordre.model.OrdreFabrication;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class OrdreFabricationMapper {
    private final DetailOfMapper detailOfMapper;

    public OrdreFabrication toOrdreFabrication(OrdreFabricationValue request) {
        if (request == null) {
            return null;
        }

        return OrdreFabrication.builder()
                .id(request.getId())
                .chaine(Chaine.builder().id(request.getChaineId()).build())
                .detailOfs(request.getDetailOfs() != null ? request.getDetailOfs().stream()
                        .map(detailOfMapper::toDetailOf)
                        .collect(Collectors.toSet()) : null)
                .quantite(request.getQuantite())
                .produitId(request.getProduitId())
                .dateDebut(request.getDateDebut())
                .dateFin(request.getDateFin())
                .priorite(request.getPriorite())
                .status(request.getStatus())
                .informationsStock(request.getInformationsStock())
                .qtCoupe(request.getQtCoupe())
                .qtEngagement(request.getQtEngagement())
                .qtSortie(request.getQtSortie())
                .qtFinition(request.getQtFinition())
                .qtColisage(request.getQtColisage())
                .qtExpedition(request.getQtExpedition())
                .qtePriseProd(request.getQtePriseProd())
                .qteRecueProd(request.getQteRecueProd())
                .qtePriseCoupe(request.getQtePriseCoupe())
                .qteRecuCoupe(request.getQteRecuCoupe())
                .qteEntreeAssemblage(request.getQteEntreeAssemblage())
                .qteSortieAssemblage(request.getQteSortieAssemblage())
                .qteEntreeFinition(request.getQteEntreeFinition())
                .qteEntreePreparation(request.getQteEntreePreparation())
                .qteSortiePreparation(request.getQteSortiePreparation())
                .modifierQtSortieManuel(request.getModifierQtSortieManuel())
                .split(request.getSplit())
                .majQteOfAvecImportation(request.getMajQteOfAvecImportation())
                .inspection(request.getInspection())
                .statusPlanning(request.getStatusPlanning())
                .qtePreteCoupe(request.getQtePreteCoupe())
                .implantation(request.getImplantation())
                .quantiteDetailOrdres(request.getQuantiteDetailOrdres())
                .nombreColis(request.getNombreColis())
                .build();
    }

    public OrdreFabricationValue fromOrdreFabrication(OrdreFabrication ordreFabrication) {
        if (ordreFabrication == null) {
            return null;
        }

        return new OrdreFabricationValue(
                ordreFabrication.getId(),
                ordreFabrication.getChaine() != null ? ordreFabrication.getChaine().getId() : null,
                ordreFabrication.getDetailOfs() != null ? ordreFabrication.getDetailOfs().stream()
                        .map(detailOfMapper::fromDetailOf)
                        .collect(Collectors.toSet()) : null,
                ordreFabrication.getQuantite(),
                ordreFabrication.getProduitId(),
                ordreFabrication.getPartieInterresId(),
                ordreFabrication.getType(),
                ordreFabrication.getDateDebut(),
                ordreFabrication.getDateFin(),
                ordreFabrication.getPriorite(),
                ordreFabrication.getStatus(),
                ordreFabrication.getInformationsStock(),
                ordreFabrication.getQtCoupe(),
                ordreFabrication.getQtEngagement(),
                ordreFabrication.getQtSortie(),
                ordreFabrication.getQtFinition(),
                ordreFabrication.getQtColisage(),
                ordreFabrication.getQtExpedition(),
                ordreFabrication.getQtePriseProd(),
                ordreFabrication.getQteRecueProd(),
                ordreFabrication.getQtePriseCoupe(),
                ordreFabrication.getQteRecuCoupe(),
                ordreFabrication.getQteEntreeAssemblage(),
                ordreFabrication.getQteSortieAssemblage(),
                ordreFabrication.getQteEntreeFinition(),
                ordreFabrication.getQteEntreePreparation(),
                ordreFabrication.getQteSortiePreparation(),
                ordreFabrication.getQtePreteCoupe(),
                ordreFabrication.getModifierQtSortieManuel(),
                ordreFabrication.getSplit(),
                ordreFabrication.getMajQteOfAvecImportation(),
                ordreFabrication.getStatusPlanning(),
                ordreFabrication.getInspection(),
                ordreFabrication.getImplantation(),
                ordreFabrication.getQuantiteDetailOrdres(),
                ordreFabrication.getNombreColis()
        );
    }

    public List<OrdreFabricationValue> fromOfList(List<OrdreFabrication> produits) {
        if (produits == null) {
            return null;
        }
        return produits.stream()
                .map(this::fromOrdreFabrication)
                .collect(Collectors.toList());
    }
}
