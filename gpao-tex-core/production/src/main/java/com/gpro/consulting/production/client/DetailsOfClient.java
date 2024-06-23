package com.gpro.consulting.production.client;

import com.gpro.consulting.production.configuration.interceptor.KeycloackRequestInterceptor;
import com.gpro.consulting.production.dto.DetailOfValue;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "details-of-service", url = "${application.config.details-of-url}", configuration = KeycloackRequestInterceptor.class)
public interface DetailsOfClient {
    @GetMapping(path = "/find/by/{id}")
    DetailOfValue findDetailOfById(@PathVariable Long id);
}
