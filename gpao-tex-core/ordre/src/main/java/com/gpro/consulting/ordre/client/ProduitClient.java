package com.gpro.consulting.ordre.client;

import com.gpro.consulting.ordre.configuration.interceptor.KeycloackRequestInterceptor;
import com.gpro.consulting.ordre.dto.ProduitValue;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@FeignClient(name= "PRODUCT-SERVICE", configuration = KeycloackRequestInterceptor.class)
public interface ProduitClient {
    @GetMapping(path = "/api/produit/pd/find/by/{id}", produces ="application/json")
    @CircuitBreaker(name = "produitClientService", fallbackMethod = "getDefaulProduitClient")
    Optional<ProduitValue> findProduitById(@PathVariable Long id);

    @GetMapping(value = "/api/produit/pd/find/all", produces ="application/json")
    @CircuitBreaker(name = "produitionService", fallbackMethod = "getAll")
    Optional<List<ProduitValue>> findAll();

    default ProduitValue getDefaulProduitClient(Long id, Exception e){
        return new ProduitValue(
                id,
                Long.parseLong("-1"),
                Long.parseLong("-1"),
                Long.parseLong("-1"),
                Long.parseLong("-1"),
                List.of(),
                List.of(),
                List.of(),
                List.of(),
                List.of(),
                List.of(),
                Long.parseLong("-1"),
                "Not avaible",
                "Not avaible",
                false,
                false,
                false,
                "Not avaible",
                -1,
                -1,
                BigDecimal.valueOf(-1),
                BigDecimal.valueOf(-1),
                "Not avaible"
        );
    }

    default List<ProduitValue> getAll(Exception e){
        return List.of();
    }
}
