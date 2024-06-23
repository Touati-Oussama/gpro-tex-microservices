package com.gpro.consulting.produit.mapper;

import com.gpro.consulting.produit.dto.SiteValue;
import com.gpro.consulting.produit.model.Site;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SiteMapper {

    public Site toSite(SiteValue request) {
        if (request == null) {
            return null;
        }

        return Site.builder()
                .id(request.getId())
                .nom(request.getNom())
                .designation(request.getDesignation())
                .abriviation(request.getAbriviation())
                .sitePrincipal(request.isSitePrincipal())
                .effidapSiteId(request.getEffidapSiteId())
                .production(request.getProduction())
                .debut(request.getDebut())
                .fin1(request.getFin1())
                .fin2(request.getFin2())
                .fin3(request.getFin3())
                .fin4(request.getFin4())
                .fin5(request.getFin5())
                .build();
    }

    public SiteValue fromSite(Site site) {
        if (site == null) {
            return null;
        }

        return new SiteValue(
                site.getId(),
                site.getNom(),
                site.getDesignation(),
                site.getAbriviation(),
                site.isSitePrincipal(),
                site.getEffidapSiteId(),
                site.getProduction(),
                site.getDebut(),
                site.getFin1(),
                site.getFin2(),
                site.getFin3(),
                site.getFin4(),
                site.getFin5()
        );
    }
    public List<SiteValue> fromSiteList(List<Site> sites) {
        if (sites == null) {
            return null;
        }
        return sites.stream()
                .map(this::fromSite)
                .collect(Collectors.toList());
    }
}

