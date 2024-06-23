package com.gpro.consulting.production.client;

import com.gpro.consulting.production.configuration.interceptor.KeycloackRequestInterceptor;
import com.gpro.consulting.production.dto.SiteValue;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "site-service", url = "${application.config.site-url}", configuration = KeycloackRequestInterceptor.class)

public interface SiteClient {
    @GetMapping(path = "/find/by/{id}")
    SiteValue findSiteById(@PathVariable Long id);
}
