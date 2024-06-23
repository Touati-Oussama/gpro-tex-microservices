package com.gpro.consulting.production.mapper;

import com.gpro.consulting.production.dto.ProductionJourValue;
import com.gpro.consulting.production.model.ProductionJour;
import org.springframework.stereotype.Component;

@Component
public class ProductionJourMapper {
    public ProductionJourValue toValue(ProductionJour productionJour) {
        return new ProductionJourValue(
                productionJour.getId(),
                productionJour.getDate(),
                productionJour.getQuantite(),
                productionJour.getObservation(),
                productionJour.getElementPlanningId(),
                productionJour.getOfId(),
                productionJour.getChaineId(),
                productionJour.getPartieInterreseId(),
                productionJour.getProduitId(),
                productionJour.getPeriode()
        );
    }

    public ProductionJour toEntity(ProductionJourValue productionJourValue) {
        ProductionJour productionJour = new ProductionJour();
        productionJour.setId(productionJourValue.id());
        productionJour.setDate(productionJourValue.date());
        productionJour.setQuantite(productionJourValue.quantite());
        productionJour.setObservation(productionJourValue.observation());
        productionJour.setElementPlanningId(productionJourValue.elementPlanningId());
        productionJour.setOfId(productionJourValue.ofId());
        productionJour.setChaineId(productionJourValue.chaineId());
        productionJour.setPartieInterreseId(productionJourValue.partieInterreseId());
        productionJour.setProduitId(productionJourValue.produitId());
        productionJour.setPeriode(productionJourValue.periode());
        return productionJour;
    }
}

