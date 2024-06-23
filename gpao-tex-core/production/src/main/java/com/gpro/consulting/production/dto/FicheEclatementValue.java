package com.gpro.consulting.production.dto;

import java.util.Calendar;
import java.util.List;

public record FicheEclatementValue(
        Long id,
        List<PaquetValue> paquets,
        List<ChaineValue> chaines,
        Long ordreId,
        Calendar dateLancement,
        String observations,
        Long nombrePaquet,
        Long quantiteEclate,
        String codeConception,
        String clientAbreviation,
        Long produitId
) {
}
