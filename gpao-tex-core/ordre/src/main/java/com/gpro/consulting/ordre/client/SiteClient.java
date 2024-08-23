package com.gpro.consulting.ordre.client;

import com.gpro.consulting.ordre.configuration.interceptor.KeycloackRequestInterceptor;
import com.gpro.consulting.ordre.dto.SiteValue;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "PRODUCT-SERVICE", configuration = KeycloackRequestInterceptor.class)

public interface SiteClient {
    @GetMapping(path = "/api/produit/site/find/by/{id}", produces ="application/json")
    @CircuitBreaker(name = "siteService", fallbackMethod = "getDefaulSite")
    Optional<SiteValue> findSiteById(@PathVariable Long id);

    default SiteValue getDefaulSite(Long id, Exception e) {
        return new SiteValue(
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
