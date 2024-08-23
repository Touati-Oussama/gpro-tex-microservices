package com.gpro.consulting.production.client;

import com.gpro.consulting.production.configuration.interceptor.KeycloackRequestInterceptor;
import com.gpro.consulting.production.dto.ChaineValue;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Calendar;

/*@FeignClient(name = "chaine-service", url = "${application.config.chaine-url}", configuration = KeycloackRequestInterceptor.class)
public interface ChaineClient {
    @GetMapping(value = "/find/by/{id}", produces = "application/json")
    ChaineValue findChaineById(@PathVariable Long id);

}*/

@FeignClient(name = "ORDER-SERVICE", configuration = KeycloackRequestInterceptor.class)
public interface ChaineClient {
    @GetMapping(value = "/api/order/chaine/find/by/{id}", produces = "application/json")
    @CircuitBreaker(name = "chaineService", fallbackMethod = "getDefaultChaine")
    ChaineValue findChaineById(@PathVariable Long id);

    default ChaineValue getDefaultChaine(Long id, Exception exception){
        ChaineValue ch = new ChaineValue(
                id,
                Long.getLong("-1"),
                Long.getLong("-1"),
                "Not avaible",
                Long.getLong("-1"),
                Calendar.getInstance(),
                false,
                "Not avaible",
                false,
                false,
                "Not avaible",
                "Not avaible",
                Long.getLong("-1")
        );
        return ch;
    }
}