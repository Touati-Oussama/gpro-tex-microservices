package com.gpro.consulting.production.dto;

import java.util.Calendar;
import java.util.List;

public record FicheColisageValue(
        Long id,
        Long orderId,
        List<ColisValue> colis,
        List<DetailsColisageValue> detailsColisages,
        String observations,
        Long nombreColis,
        Long quantiteColis,
        String numeroOf,
        Long quantiteTotale,
        Long produitId,
        Long clientId,
        String clientAbreviation,
        String clientReference,
        String couleur,
        String produitDesignationInfo1,
        String numeroInterne,
        Calendar dateDe,
        Calendar dateA

) {
}
