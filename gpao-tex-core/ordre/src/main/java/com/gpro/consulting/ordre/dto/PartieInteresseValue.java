package com.gpro.consulting.ordre.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PartieInteresseValue {
    Long id;
    Long siteId;
    String reference;
    String matrFiscal;
    String abreviation;
    String adresseLiv;
    String modalitePaiement;
    List<DocumentPiValue> documents;
    List<RepresentantValue> representants;
    String creatorIdentifier;
    String latestUpdaterId;
}
