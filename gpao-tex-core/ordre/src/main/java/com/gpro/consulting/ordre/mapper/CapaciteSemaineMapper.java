package com.gpro.consulting.ordre.mapper;

import com.gpro.consulting.ordre.dto.CapaciteSemaineValue;
import com.gpro.consulting.ordre.model.CapaciteSemaine;
import org.springframework.stereotype.Component;

@Component
public class CapaciteSemaineMapper {
    public CapaciteSemaine toCs(CapaciteSemaineValue request) {
        if (request == null) {
            return null;
        }

        return CapaciteSemaine.builder()
                .id(request.getId())
                .semaine(request.getSemaine())
                .semainesDe(request.getSemainesDe())
                .semainesA(request.getSemainesA())
                .capaciteTotale(request.getCapaciteTotale())
                .capacitePrevisionnelle(request.getCapacitePrevisionnelle())
                .nombreHeure(request.getNombreHeure())
                .tauxAbsence(request.getTauxAbsence())
                .fin1(request.getFin1())
                .atelierId(request.getAtelierId())
                .annee(request.getAnnee())
                .build();
    }

    public CapaciteSemaineValue fromCs(CapaciteSemaine capaciteSemaine) {
        if (capaciteSemaine == null) {
            return null;
        }

        return new CapaciteSemaineValue(
                capaciteSemaine.getId(),
                capaciteSemaine.getSemaine(),
                capaciteSemaine.getSemainesDe(),
                capaciteSemaine.getSemainesA(),
                capaciteSemaine.getCapaciteTotale(),
                capaciteSemaine.getCapacitePrevisionnelle(),
                capaciteSemaine.getNombreHeure(),
                capaciteSemaine.getTauxAbsence(),
                capaciteSemaine.getFin1(),
                capaciteSemaine.getAtelierId(),
                capaciteSemaine.getAnnee()
        );
    }
}
