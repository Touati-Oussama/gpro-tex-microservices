package com.gpro.consulting.ordre.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SiteValue {
    Long id;
    String nom;
    String designation;
    String abriviation;
    boolean sitePrincipal;
    Long effidapSiteId;
    Boolean production;
    Long debut;
    Long fin1;
    Long fin2;
    Long fin3;
    Long fin4;
    Long fin5;
}
