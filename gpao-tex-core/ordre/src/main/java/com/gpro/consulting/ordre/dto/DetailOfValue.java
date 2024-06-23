package com.gpro.consulting.ordre.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetailOfValue {
    Long id;
    Long quantite;
    Long ordreId;
    Long pcb;
    Long tailleId;
    Long couleurId;
    String typeOrdre;
    String lieuLivraison;
    String dimension;
    String ue;
    String code;
    String codeCouleur;
    Double poidsNet;
    Double poidsBrut;
    Long qteRecuCoupe;
    Long qtePreteCoupe;
    Long qtePriseProd;
    Long qtePriseCoupe;
    Long qteRecueProd;
    Long qteProduite;
}
