package com.gpro.consulting.ordre.client;

import com.gpro.consulting.ordre.configuration.interceptor.KeycloackRequestInterceptor;
import com.gpro.consulting.ordre.dto.ProduitValue;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "product-service", url = "${application.config.pd-url}", configuration = KeycloackRequestInterceptor.class)
public interface ProduitClient {
    @GetMapping(path = "/find/by/{id}")
    Optional<ProduitValue> findProduitById(@PathVariable Long id);

    @GetMapping(value = "/find/all")
    Optional<List<ProduitValue>> findAll();
}
