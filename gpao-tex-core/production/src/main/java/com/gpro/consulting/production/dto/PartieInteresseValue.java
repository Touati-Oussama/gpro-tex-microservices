package com.gpro.consulting.production.dto;

import java.util.List;

public record PartieInteresseValue(
        Long id,
        Long siteId,
        String reference,
        String matrFiscal,
        String abreviation,
        String adresseLiv,
        String modalitePaiement,
        List<DocumentPiValue> documents,
        List<RepresentantValue> representants
) {
}
