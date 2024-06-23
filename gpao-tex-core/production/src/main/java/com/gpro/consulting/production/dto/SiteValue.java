package com.gpro.consulting.production.dto;

public record SiteValue(
        Long id,
        String nom,
        String designation,
        String abriviation,
        boolean sitePrincipal,
        Long effidapSiteId,
        Boolean production,
        Long debut,
        Long fin1,
        Long fin2,
        Long fin3,
        Long fin4,
        Long fin5
) {
}
