package com.gpro.consulting.production.client;

import com.gpro.consulting.production.configuration.interceptor.KeycloackRequestInterceptor;
import com.gpro.consulting.production.dto.OrdreFabricationValue;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "of-service", url = "${application.config.of-url}", configuration = KeycloackRequestInterceptor.class)
public interface OfClient {

    @GetMapping(path = "/find/by/{id}")
    OrdreFabricationValue findOfById(@PathVariable Long id);

}
