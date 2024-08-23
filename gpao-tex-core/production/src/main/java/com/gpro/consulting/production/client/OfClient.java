package com.gpro.consulting.production.client;

import com.gpro.consulting.production.configuration.interceptor.KeycloackRequestInterceptor;
import com.gpro.consulting.production.dto.DetailOfValue;
import com.gpro.consulting.production.dto.OrdreFabricationValue;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Calendar;
import java.util.Set;

/*@FeignClient(name = "of-service", url = "${application.config.of-url}", configuration = KeycloackRequestInterceptor.class)
public interface OfClient {
    @GetMapping(path = "/find/by/{id}")
    OrdreFabricationValue findOfById(@PathVariable Long id);
}*/
@FeignClient(name = "ORDER-SERVICE", configuration = KeycloackRequestInterceptor.class)
public interface OfClient {
    @GetMapping(value = "/api/ordre/of/find/by/{id}", produces ="application/json")
    @CircuitBreaker(name = "ofService", fallbackMethod = "getDefaultOf")
    OrdreFabricationValue findOfById(@PathVariable Long id);

    default OrdreFabricationValue getDefaultOf(Long id, Exception e){
        return  new OrdreFabricationValue(
                id,
                Long.parseLong("-1"),
                Set.of(),
                -1,
                Long.parseLong("-1"),
                Calendar.getInstance(),
                Calendar.getInstance(),
                "Not  avaible",
                "Not avaible",
                "Not avaible",
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                -1,
                Long.parseLong("-1"),
                Long.parseLong("-1"),
                Long.parseLong("-1"),
                Long.parseLong("-1"),
                Long.parseLong("-1")
                );
    }

}