package com.gpro.consulting.produit.configuration;

import com.gpro.consulting.produit.configuration.converter.JwtAuthConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class KeycloakSecurityConfig {

    private final JwtAuthConverter jwtAuthConverter;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .cors(Customizer.withDefaults())
                .authorizeHttpRequests(req ->
                        req.requestMatchers(
                                        "/auth/**",
                                        "/v2/api-docs",
                                        "/v3/api-docs",
                                        "/v3/api-docs/**",
                                        "/swagger-resources",
                                        "/swagger-resources/**",
                                        "/configuration/ui",
                                        "/configuration/security",
                                        "/swagger-ui/**",
                                        "/webjars/**",
                                        "/swagger-ui.html",
                                        "/actuator/**")
                                .permitAll()
                )
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers("/api/produit/pd/**").hasAnyAuthority("Admin", "Responsable_commercial")
                        .requestMatchers("/api/produit/pe/**").hasAnyAuthority("Admin", "Responsable_production")
                        .requestMatchers("/api/produit/couleur/**").hasAnyAuthority("Admin", "Responsable_ordonnancement")
                        .requestMatchers("/api/produit/Taille/**").hasAnyAuthority("Admin", "Responsable_ordonnancement")
                        .requestMatchers("/api/produit/sfpd/**").hasAnyAuthority("Admin", "Responsable_ordonnancement")
                        .anyRequest()  // All unmatched URLs
                        .hasAuthority("Admin") // Require "Admin" role for access

                );
        http.oauth2ResourceServer(server -> server.jwt(jwt -> jwt.jwtAuthenticationConverter(jwtAuthConverter)));
        http.sessionManagement(session -> session.sessionCreationPolicy(STATELESS));
        return http.build();
    }
}
