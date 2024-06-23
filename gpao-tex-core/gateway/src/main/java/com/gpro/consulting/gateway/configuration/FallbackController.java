package com.gpro.consulting.gateway.configuration;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cb")
public class FallbackController {

    @GetMapping("/productServiceFallBack")
    public String productServiceFallBack(Exception ex) {
        return "Le microservice produit n'est pas disponible. Réessayez ultérieurement.";
    }

    @GetMapping("/orderServiceFallBack")
    public String orderServiceFallBack(Exception ex) {
        return "Le microservice ordre n'est pas disponible. Réessayez ultérieurement.";
    }

    @GetMapping("/productionServiceFallBack")
    public String productionServiceFallBack(Exception ex) {
        return "Le microservice production n'est pas disponible. Réessayez ultérieurement.";
    }

    @GetMapping("/partiePrenanteServiceFallBack")
    public String operationsServiceFallBack(Exception ex) {
        return "Le microservice operations n'est pas disponible. Réessayez ultérieurement.";
    }
}
