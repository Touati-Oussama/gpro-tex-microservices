package com.gpro.consulting.ordre.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Calendar;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ColisValue {
    Long id;
    Long ficheColisageId;
    Long ordreId;
    Long couleurId;
    Long tailleId;
    Long siteId;
    Long produitId;
    String tailles;
    Long quantite;
    Double poidsNet;
    Double poidsBrut;
    String palette;
    Calendar dateSortie;
    Calendar dateLancementDe;
    Calendar dateLancementA;
}
