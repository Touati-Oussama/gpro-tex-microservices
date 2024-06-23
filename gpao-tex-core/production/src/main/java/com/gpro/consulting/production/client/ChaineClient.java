package com.gpro.consulting.production.client;

import com.gpro.consulting.production.configuration.interceptor.KeycloackRequestInterceptor;
import com.gpro.consulting.production.dto.ChaineValue;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "chaine-service", url = "${application.config.chaine-url}", configuration = KeycloackRequestInterceptor.class)
public interface ChaineClient {
    @GetMapping(value = "/find/by/{id}", produces = "application/json")
    ChaineValue findChaineById(@PathVariable Long id);

}
