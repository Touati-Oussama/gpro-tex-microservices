package com.gpro.consulting.ordre.client;

import com.gpro.consulting.ordre.configuration.interceptor.KeycloackRequestInterceptor;
import com.gpro.consulting.ordre.dto.CouleurValue;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

/*@FeignClient(name = "couleur-service", url = "${application.config.couleur-url}", configuration = KeycloackRequestInterceptor.class)
public interface CouleurClient {
    @GetMapping(path = "/find/by/{id}")
    Optional<CouleurValue> findCouleurById(@PathVariable Long id);

    @PostMapping("/getAllInList")
    List<CouleurValue> getAllInList(@RequestBody List<Long> ids);
}*/

@FeignClient(name = "PRODUCT-SERVICE",configuration = KeycloackRequestInterceptor.class)
public interface CouleurClient {

    @GetMapping(path = "/api/produit/couleur/find/by/{id}", produces = "application/json")
    @CircuitBreaker(name = "couleurService", fallbackMethod = "getDefaultCouleur")
    Optional<CouleurValue> findCouleurById(@PathVariable Long id);

    @PostMapping("/api/produit/couleur/getAllInList")
    @CircuitBreaker(name = "couleurService", fallbackMethod = "getAllCouleurs")
    List<CouleurValue> getAllInList(@RequestBody List<Long> ids);


    default List<CouleurValue> getAllCouleurs(Exception e){ return List.of();}

    default Optional<CouleurValue> getDefaultCouleur(Long id, Exception exception){
        return Optional.of( new CouleurValue(
                id,
                Long.parseLong("-1"),
                "Not avaible",
                "Not avaible"
        ));
    }
}