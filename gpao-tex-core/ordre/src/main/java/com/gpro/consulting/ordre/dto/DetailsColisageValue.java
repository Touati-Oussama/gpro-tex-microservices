package com.gpro.consulting.ordre.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetailsColisageValue {
    Long id;
    Long ficheColisageId;
    Long couleurId;
    Long tailleId;
    Long quantiteRestante;
    Long quantite;
    Long pcb;
    String tailleDesignation;
    String couleurDesignation;
    Double poidsNet;
    Double poidsBrut;
    String choix;
    String tailles;
    String code;
    String codeCouleur;
    String quantiteDesignation;
}
