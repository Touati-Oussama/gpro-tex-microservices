package com.gpro.consulting.production.client;

import com.gpro.consulting.production.configuration.interceptor.KeycloackRequestInterceptor;
import com.gpro.consulting.production.dto.DetailOfValue;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/*@FeignClient(name = "details-of-service", url = "${application.config.details-of-url}", configuration = KeycloackRequestInterceptor.class)
public interface DetailsOfClient {
    @GetMapping(path = "/find/by/{id}")
    DetailOfValue findDetailOfById(@PathVariable Long id);
}*/

@FeignClient(name = "ORDER-SERVICE", configuration = KeycloackRequestInterceptor.class)
public interface DetailsOfClient {
    @GetMapping(value = "/api/ordre/detailsOf/find/by/{id}", produces ="application/json")
    @CircuitBreaker(name = "detailOfService", fallbackMethod = "getDefaultDetailOf")
    DetailOfValue findDetailOfById(@PathVariable Long id);

    default DetailOfValue getDefaultDetailOf(Long id, Exception exception){
        return new DetailOfValue(
                id,
                Long.parseLong("-1"),
                Long.parseLong("-1"),
                Long.parseLong("-1"),
                Long.parseLong("-1"),
                "Not avaible",
                "Not avaible",
                "Not avaible",
                "Not avaible",
                "Not avaible",
                "Not avaible",
                Double.parseDouble("-1"),
                Double.parseDouble("-1")
        );
    }
}
