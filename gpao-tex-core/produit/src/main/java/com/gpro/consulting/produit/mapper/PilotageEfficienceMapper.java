package com.gpro.consulting.produit.mapper;

import com.gpro.consulting.produit.dto.PilotageEfficienceValue;
import com.gpro.consulting.produit.model.PilotageEfficience;
import com.gpro.consulting.produit.model.Produit;
import com.gpro.consulting.produit.model.Site;
import org.springframework.stereotype.Component;

@Component
public class PilotageEfficienceMapper {

    public PilotageEfficience toPilotageEfficience(PilotageEfficienceValue request) {
        if (request == null) {
            return null;
        }

        return PilotageEfficience.builder()
                .id(request.getId())
                .site(request.getSiteId() != null ?
                        Site.builder().id(request.getSiteId()).build() : null)
                .produit(request.getProduitId() != null ?
                        Produit.builder().id(request.getProduitId()).build() : null)
                .efficienceJour1(request.getEfficienceJour1())
                .efficienceJour2(request.getEfficienceJour2())
                .efficienceJour3(request.getEfficienceJour3())
                .efficienceJour4(request.getEfficienceJour4())
                .efficienceJour5(request.getEfficienceJour5())
                .efficienceJour6(request.getEfficienceJour6())
                .efficienceJour7(request.getEfficienceJour7())
                .build();
    }

    public PilotageEfficienceValue fromPilotageEfficience(PilotageEfficience pilotageEfficience) {
        if (pilotageEfficience == null) {
            return null;
        }

        return new PilotageEfficienceValue(
                pilotageEfficience.getId(),
                pilotageEfficience.getSite().getId(),
                pilotageEfficience.getProduit().getId(),
                pilotageEfficience.getEfficienceJour1(),
                pilotageEfficience.getEfficienceJour2(),
                pilotageEfficience.getEfficienceJour3(),
                pilotageEfficience.getEfficienceJour4(),
                pilotageEfficience.getEfficienceJour5(),
                pilotageEfficience.getEfficienceJour6(),
                pilotageEfficience.getEfficienceJour7()
        );
    }
}

