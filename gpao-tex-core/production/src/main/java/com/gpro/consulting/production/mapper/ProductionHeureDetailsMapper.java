package com.gpro.consulting.production.mapper;

import com.gpro.consulting.production.dto.ProductionHeureDetailsValue;
import com.gpro.consulting.production.model.ProductionHeure;
import com.gpro.consulting.production.model.ProductionHeureDetails;
import org.springframework.stereotype.Component;

@Component
public class ProductionHeureDetailsMapper {

    public ProductionHeureDetails toProductionHeureDetails(ProductionHeureDetailsValue request) {
        if (request == null) {
            return null;
        }

        return ProductionHeureDetails.builder()
                .id(request.id())
                .detailsId(request.detailsId())
                .productionHeure(request.productionHeureId() != null ?
                        ProductionHeure.builder().id(request.productionHeureId()).build() : null)
                .qteFinie(request.qteFinie())
                .qteNonEmballe(request.qteNonEmballe())
                .qteRetouche(request.qteRetouche())
                .qteDeuxiemeChoix(request.qteDeuxiemeChoix())
                .nbreColis(request.nbreColis())
                .date(request.date())
                .numPaquet(request.numPaquet())
                .paquetId(request.paquetId())
                .colisId(request.colisId())
                .complement(request.complement())
                .quantite(request.quantite())
                .operation(request.operation())
                .observations(request.observations())
                .tailleId(request.tailleId())
                .couleurId(request.couleurId())
                .ordrePaquet(request.ordrePaquet())
                .numMatelasPaquet(request.numMatelasPaquet())
                .nature(request.nature())
                .build();
    }

    public ProductionHeureDetailsValue fromProductionHeureDetails(ProductionHeureDetails productionHeureDetails) {
        if (productionHeureDetails == null) {
            return null;
        }

        return new ProductionHeureDetailsValue(
                productionHeureDetails.getId(),
                productionHeureDetails.getDetailsId(),
                productionHeureDetails.getProductionHeure() != null ? productionHeureDetails.getProductionHeure().getId() : null,
                productionHeureDetails.getQteFinie(),
                productionHeureDetails.getQteNonEmballe(),
                productionHeureDetails.getQteRetouche(),
                productionHeureDetails.getQteDeuxiemeChoix(),
                productionHeureDetails.getNbreColis(),
                productionHeureDetails.getDate(),
                productionHeureDetails.getNumPaquet(),
                productionHeureDetails.getPaquetId(),
                productionHeureDetails.getColisId(),
                productionHeureDetails.getComplement(),
                productionHeureDetails.getQuantite(),
                productionHeureDetails.getOperation(),
                productionHeureDetails.getObservations(),
                productionHeureDetails.getTailleId(),
                productionHeureDetails.getCouleurId(),
                productionHeureDetails.getOrdrePaquet(),
                productionHeureDetails.getNumMatelasPaquet(),
                productionHeureDetails.getNature()
        );
    }
}

