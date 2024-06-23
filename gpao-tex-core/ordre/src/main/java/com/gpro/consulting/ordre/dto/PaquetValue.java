package com.gpro.consulting.ordre.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaquetValue {
    Long id;
    Long ordreFabricationId;
    Long ficheEclatementId;
    Long num;
    Boolean productionHeure;
    Long siteId;
    Long couleurId;
    Long tailleId;
    Long quantite;
    String numMatelas;
    String numRouleaux;
    Boolean entreeDos;
    Boolean sortieDos;
    Boolean entreeDevant;
    Boolean sortieDevant;
    Boolean sortieAssemblage;
    Boolean entreeAssemblage;
    Boolean entreeFinition;
    Boolean entreePreparation;
    Boolean sortiePreparation;
    Boolean engagement;
    String retrait;
}
