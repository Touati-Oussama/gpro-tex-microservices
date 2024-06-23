package com.gpro.consulting.production.client;

import com.gpro.consulting.production.configuration.interceptor.KeycloackRequestInterceptor;
import com.gpro.consulting.production.dto.ProduitValue;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "product-service", url = "${application.config.pd-url}", configuration = KeycloackRequestInterceptor.class)
public interface ProduitClient {
    @GetMapping(path = "/find/by/{id}")
    ProduitValue findProduitById(@PathVariable Long id);

    @GetMapping(value = "/find/all")
    List<ProduitValue> findAll();

}
