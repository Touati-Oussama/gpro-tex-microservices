package com.gpro.consulting.produit.configuration;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;

public class KeycloackRequestInterceptor {

    @Bean
    public RequestInterceptor bearerTokenInterceptor() {
        return requestTemplate -> {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (authentication != null && authentication.getPrincipal() instanceof Jwt token) {
                requestTemplate.header("Authorization", "Bearer " + token.getTokenValue());
            }
        };
    }
}
