package com.gpro.consulting.ordre.client;

import com.gpro.consulting.ordre.configuration.interceptor.KeycloackRequestInterceptor;
import com.gpro.consulting.ordre.dto.CouleurValue;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "couleur-service", url = "${application.config.couleur-url}", configuration = KeycloackRequestInterceptor.class)
public interface CouleurClient {
    @GetMapping(path = "/find/by/{id}")
    Optional<CouleurValue> findCouleurById(@PathVariable Long id);

    @PostMapping("/getAllInList")
    List<CouleurValue> getAllInList(@RequestBody List<Long> ids);
}
