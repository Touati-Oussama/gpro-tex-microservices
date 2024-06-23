package com.gpro.consulting.ordre.client;

import com.gpro.consulting.ordre.configuration.interceptor.KeycloackRequestInterceptor;
import com.gpro.consulting.ordre.dto.SiteValue;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "site-service", url = "${application.config.site-url}", configuration = KeycloackRequestInterceptor.class)

public interface SiteClient {
    @GetMapping(path = "/find/by/{id}")
    Optional<SiteValue> findSiteById(@PathVariable Long id);
}
