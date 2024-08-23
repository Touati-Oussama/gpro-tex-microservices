package com.gpro.consulting.production.client;

import com.gpro.consulting.production.configuration.interceptor.KeycloackRequestInterceptor;
import com.gpro.consulting.production.dto.SiteValue;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/*@FeignClient(name = "site-service", url = "${application.config.site-url}", configuration = KeycloackRequestInterceptor.class)

public interface SiteClient {
    @GetMapping(path = "/find/by/{id}")
    SiteValue findSiteById(@PathVariable Long id);
}*/

@FeignClient(name = "PRODUCT-SERVICE", configuration = KeycloackRequestInterceptor.class)
public interface SiteClient {

    @GetMapping(value = "/api/produit/site/find/by/{id}", produces ="application/json")
    @CircuitBreaker(name = "siteService", fallbackMethod = "getDefaulSite")
    SiteValue findSiteById(@PathVariable Long id);

    default SiteValue getDefaulSite(Long id, Exception e){
        return  new SiteValue(
                id,
                "Not avaible",
                "Not avaible",
                "Not avaible",
                false,
                Long.parseLong("-1"),
                false,
                Long.parseLong("-1"),
                Long.parseLong("-1"),
                Long.parseLong("-1"),
                Long.parseLong("-1"),
                Long.parseLong("-1"),
                Long.parseLong("-1")
                );
    }
}

