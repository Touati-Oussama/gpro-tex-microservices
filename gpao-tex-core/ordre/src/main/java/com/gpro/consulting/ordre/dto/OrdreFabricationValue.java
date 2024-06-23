package com.gpro.consulting.ordre.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Calendar;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrdreFabricationValue {
    Long id;
    Long chaineId;
    Set<DetailOfValue> detailOfs;
    Long quantite;
    Long produitId;
    Long partieInterresId;
    String type;
    Calendar dateDebut;
    Calendar dateFin;
    String priorite;
    String status;
    String informationsStock;
    Long qtCoupe;
    Long qtEngagement;
    Long qtSortie;
    Long qtFinition;
    Long qtColisage;
    Long qtExpedition;
    Long qtePriseProd;
    Long qteRecueProd;
    Long qtePriseCoupe;
    Long qteRecuCoupe;
    Long qteEntreeAssemblage;
    Long qteSortieAssemblage;
    Long qteEntreeFinition;
    Long qteEntreePreparation;
    Long qteSortiePreparation;
    Long qtePreteCoupe;
    Boolean modifierQtSortieManuel;
    Boolean split;
    Boolean majQteOfAvecImportation;
    String statusPlanning;
    String inspection;
    String implantation;
    Long quantiteDetailOrdres;
    Long nombreColis;
}
