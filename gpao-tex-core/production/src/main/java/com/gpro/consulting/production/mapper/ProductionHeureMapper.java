package com.gpro.consulting.production.mapper;

import com.gpro.consulting.production.dto.ProductionHeureDetailsValue;
import com.gpro.consulting.production.dto.ProductionHeureValue;
import com.gpro.consulting.production.model.ProductionHeure;
import com.gpro.consulting.production.model.ProductionHeureDetails;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class ProductionHeureMapper {
    private ProductionHeureDetailsMapper productionHeureDetailsMapper;

    public ProductionHeure toProductionHeure(ProductionHeureValue request) {
        if (request == null) {
            return null;
        }

        List<ProductionHeureDetails> productionHeureDetails = request.productionHeureDetails() != null ? request.productionHeureDetails().stream()
                .map(productionHeureDetailsMapper::toProductionHeureDetails)
                .collect(Collectors.toList()) : null;

        return ProductionHeure.builder()
                .id(request.id())
                .date(request.date())
                .quantite(request.quantite())
                .observation(request.observation())
                .elementPlanningId(request.elementPlanningId())
                .ofId(request.ofId())
                .chaineId(request.chaineId())
                .partieInterreseId(request.partieInterreseId())
                .produitId(request.produitId())
                .periode(request.periode())
                .productionHeureDetails(productionHeureDetails)
                .build();
    }

    public ProductionHeureValue fromProductionHeure(ProductionHeure productionHeure) {
        if (productionHeure == null) {
            return null;
        }

        List<ProductionHeureDetailsValue> productionHeureDetailsValues = productionHeure.getProductionHeureDetails() != null ? productionHeure.getProductionHeureDetails().stream()
                .map(productionHeureDetailsMapper::fromProductionHeureDetails)
                .collect(Collectors.toList()) : null;

        return new ProductionHeureValue(
                productionHeure.getId(),
                productionHeure.getDate(),
                productionHeure.getQuantite(),
                productionHeure.getObservation(),
                productionHeure.getElementPlanningId(),
                productionHeure.getOfId(),
                productionHeure.getChaineId(),
                productionHeure.getPartieInterreseId(),
                productionHeure.getProduitId(),
                productionHeure.getPeriode(),
                productionHeureDetailsValues
        );
    }
}

