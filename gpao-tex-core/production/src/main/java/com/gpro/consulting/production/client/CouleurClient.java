package com.gpro.consulting.production.client;

import com.gpro.consulting.production.configuration.interceptor.KeycloackRequestInterceptor;
import com.gpro.consulting.production.dto.CouleurValue;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "couleur-service", url = "${application.config.couleur-url}", configuration = KeycloackRequestInterceptor.class)
public interface CouleurClient {
    @GetMapping(path = "/find/by/{id}")
    CouleurValue findCouleurById(@PathVariable Long id);
}
