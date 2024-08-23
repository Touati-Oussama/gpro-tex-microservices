package com.gpro.consulting.production.client;

import com.gpro.consulting.production.configuration.interceptor.KeycloackRequestInterceptor;
import com.gpro.consulting.production.dto.CouleurValue;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
/*
@FeignClient(name = "couleur-service", url = "${application.config.couleur-url}", configuration = KeycloackRequestInterceptor.class)
public interface CouleurClient {
    @GetMapping(path = "/find/by/{id}")
    CouleurValue findCouleurById(@PathVariable Long id);
}*/

@FeignClient(name = "PRODUCT-SERVICE", configuration = KeycloackRequestInterceptor.class)
public interface CouleurClient {

    @GetMapping(value = "/api/produit/couleur/find/by/{id}", produces = "application/json")
    @CircuitBreaker(name = "couleurService", fallbackMethod = "getDefaultCouleur")
    CouleurValue findCouleurById(@PathVariable Long id);

    default CouleurValue getDefaultCouleur(Long id, Exception exception){
        return new CouleurValue(
                id,
                Long.parseLong("-1"),
                "Not avaible",
                "Not avaible"
        );
    }
}