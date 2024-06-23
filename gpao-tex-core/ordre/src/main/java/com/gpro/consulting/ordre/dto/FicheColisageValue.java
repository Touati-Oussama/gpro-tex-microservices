package com.gpro.consulting.ordre.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Calendar;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FicheColisageValue {
    Long id;
    Long orderId;
    List<ColisValue> colis;
    List<DetailsColisageValue> detailsColisages;
    String observations;
    Long nombreColis;
    Long quantiteColis;
    String numeroOf;
    Long quantiteTotale;
    Long produitId;
    Long clientId;
    String clientAbreviation;
    String clientReference;
    String couleur;
    String produitDesignationInfo1;
    String numeroInterne;
    Calendar dateDe;
    Calendar dateA;
}
