package com.gpro.consulting.produit.client;

import com.gpro.consulting.produit.configuration.KeycloackRequestInterceptor;
import com.gpro.consulting.produit.dto.PartieInteresseValue;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "pi-service", url = "${application.config.pi-url}", configuration = KeycloackRequestInterceptor.class)
public interface PiClient {
    @GetMapping(path = "/find/by/{id}")
    Optional<PartieInteresseValue> findPiById(@PathVariable Long id);
}
