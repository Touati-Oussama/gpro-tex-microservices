package com.gpro.consulting.production.client;

import com.gpro.consulting.production.configuration.interceptor.KeycloackRequestInterceptor;
import com.gpro.consulting.production.dto.TailleValue;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
/*
@FeignClient(name = "taille-service", url = "${application.config.taille-url}", configuration = KeycloackRequestInterceptor.class)
public interface TailleClient {
    @GetMapping(path = "/find/by/{id}")
    TailleValue findTailleById(@PathVariable Long id);
}*/
@FeignClient(name = "PRODUCT-SERVICE", configuration = KeycloackRequestInterceptor.class)
public interface TailleClient {

    @GetMapping(value = "/api/produit/taille/find/by/{id}", produces ="application/json")
    @CircuitBreaker(name = "tailleService", fallbackMethod = "getDefaultTaille")
    TailleValue findTailleById(@PathVariable Long id);

    default TailleValue getDefaultTaille(Long id, Exception e){
        return new TailleValue(
                id,
                Long.parseLong("-1"),
                "Not avaible",
                -1,
                "Not Avaible"
        );
    }


}

