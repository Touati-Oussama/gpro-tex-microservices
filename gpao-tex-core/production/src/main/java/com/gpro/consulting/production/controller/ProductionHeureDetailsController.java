package com.gpro.consulting.production.controller;

import com.gpro.consulting.production.dto.ProductionHeureDetailsValue;
import com.gpro.consulting.production.model.ProductionHeureDetails;
import com.gpro.consulting.production.service.ProductionHeureDetailsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/production/prodHeureDetails")
public class ProductionHeureDetailsController {
    private final ProductionHeureDetailsService service;

    @PostMapping("/createProdHeureDetails")
    public ResponseEntity<ProductionHeureDetails> createProdHeureDetails(@RequestBody @Valid ProductionHeureDetailsValue request) {
        return ResponseEntity.ok(service.createProductionHeureDetails(request));
    }

    @GetMapping(path = "/find/by/{id}")
    public ResponseEntity<ProductionHeureDetailsValue> findProdHeureDetailsById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProdHeureDetails(@PathVariable(name = "id") Long id) {
        this.service.delete(id);
        return ResponseEntity.accepted().build();
    }

    @GetMapping(value = "/find/all", produces = "application/json")
    public ResponseEntity<List<ProductionHeureDetailsValue>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
}
