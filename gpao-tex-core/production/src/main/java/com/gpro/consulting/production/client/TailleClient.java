package com.gpro.consulting.production.client;

import com.gpro.consulting.production.configuration.interceptor.KeycloackRequestInterceptor;
import com.gpro.consulting.production.dto.TailleValue;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "taille-service", url = "${application.config.taille-url}", configuration = KeycloackRequestInterceptor.class)
public interface TailleClient {
    @GetMapping(path = "/find/by/{id}")
    TailleValue findTailleById(@PathVariable Long id);
}
