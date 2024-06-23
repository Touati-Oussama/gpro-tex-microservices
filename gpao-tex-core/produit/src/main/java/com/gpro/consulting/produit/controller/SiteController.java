package com.gpro.consulting.produit.controller;

import com.gpro.consulting.produit.dto.SiteValue;
import com.gpro.consulting.produit.service.SiteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/produit/site")
@RequiredArgsConstructor
public class SiteController {
    private final SiteService service;

    @PostMapping("/createSite")
    public ResponseEntity<String> createSite(@RequestBody @Valid SiteValue request) {
        return ResponseEntity.ok(service.createSite(request));
    }

    @GetMapping(path = "/find/by/{id}")
    public ResponseEntity<SiteValue> findSiteById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteSite(@PathVariable(name = "id") Long id) {
        this.service.delete(id);
        return ResponseEntity.accepted().build();
    }

    @GetMapping(value = "/find/all", produces = "application/json")
    public ResponseEntity<List<SiteValue>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(value = "/findBySitePrincipale", produces = "application/json")
    public ResponseEntity<List<SiteValue>> findBySitePrincipale() {
        return ResponseEntity.ok(service.findAllBySitePrincipal());
    }
}
