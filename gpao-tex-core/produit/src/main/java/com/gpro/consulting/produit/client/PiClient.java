package com.gpro.consulting.produit.client;

import com.gpro.consulting.produit.configuration.KeycloackRequestInterceptor;
import com.gpro.consulting.produit.dto.PartieInteresseValue;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;



@FeignClient(name = "PARTIE-PRENANTE", configuration = KeycloackRequestInterceptor.class)
public interface PiClient {
    @GetMapping(path = "/api/operations/pi/find/by/{id}")
    @CircuitBreaker(name = "partieInterseeService", fallbackMethod = "getDefaultPartieInteresse")
    Optional<PartieInteresseValue> findPiById(@PathVariable Long id);

    default Optional<PartieInteresseValue> getDefaultPartieInteresse(Long id, Exception exception){
        PartieInteresseValue partieInteresseValue = new PartieInteresseValue();
        partieInteresseValue.setId(id);
        partieInteresseValue.setSiteId(Long.parseLong("-1"));
        partieInteresseValue.setReference("Not avaible");
        partieInteresseValue.setMatrFiscal("Not avaible");
        partieInteresseValue.setAbreviation("Not avaible");
        partieInteresseValue.setAdresseLiv("Not avaible");
        partieInteresseValue.setModalitePaiement("Not avaible");
        partieInteresseValue.setDocuments(List.of());
        partieInteresseValue.setRepresentants(List.of());
        partieInteresseValue.setLatestUpdaterId("Not avaible");
        partieInteresseValue.setCreatorIdentifier("Not avaible");
        return Optional.of(partieInteresseValue);
    }

}
