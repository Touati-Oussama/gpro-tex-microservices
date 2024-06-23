package com.gpro.consulting.ordre.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Calendar;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChaineValue {
    Long id;
    Long ficheEclatementId;
    Long ordreId;
    String designation;
    Long siteId;
    Calendar dateLibre;
    boolean planning;
    String designationClient;
    Boolean production;
    Boolean developpement;
    String posteQualite1;
    String defaut1;
    Long nbDefaut1;
}
