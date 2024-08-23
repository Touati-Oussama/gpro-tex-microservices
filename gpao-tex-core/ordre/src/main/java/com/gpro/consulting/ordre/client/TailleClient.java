package com.gpro.consulting.ordre.client;

import com.gpro.consulting.ordre.configuration.interceptor.KeycloackRequestInterceptor;
import com.gpro.consulting.ordre.dto.CouleurValue;
import com.gpro.consulting.ordre.dto.TailleValue;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "PRODUCT-SERVICE", configuration = KeycloackRequestInterceptor.class)
public interface TailleClient {
    @GetMapping(path = "/api/produit/taille/find/by/{id}", produces ="application/json")
    @CircuitBreaker(name = "tailleService", fallbackMethod = "getDefaultTaille")
    Optional<TailleValue> findTailleById(@PathVariable Long id);

    @PostMapping("/api/produit/taille/getAllInList")
    @CircuitBreaker(name = "tailleService", fallbackMethod = "getAll")
    List<CouleurValue> getAllInList(@RequestBody List<Long> ids);


    default TailleValue getDefaultTaille(Long id, Exception e){
        return new TailleValue(
                id,
                Long.parseLong("-1"),
                "Not avaible",
                -1,
                "Not Avaible"
        );
    }

    default List<CouleurValue> getAll(Exception e){ return List.of();}
}
