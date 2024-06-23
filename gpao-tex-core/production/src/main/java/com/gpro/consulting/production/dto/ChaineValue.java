package com.gpro.consulting.production.dto;

import java.util.Calendar;

public record ChaineValue(
        Long id,
        Long ficheEclatementId,
        Long ordreId,
        String designation,
        Long siteId,
        Calendar dateLibre,
        boolean planning,
        String designationClient,
        Boolean production,
        Boolean developpement,
        String posteQualite1,
        String defaut1,
        Long nbDefaut1
) {
}
