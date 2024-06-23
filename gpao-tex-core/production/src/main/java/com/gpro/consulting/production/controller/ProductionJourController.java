package com.gpro.consulting.production.controller;

import com.gpro.consulting.production.dto.ProductionJourValue;
import com.gpro.consulting.production.model.ProductionJour;
import com.gpro.consulting.production.service.ProductionJourService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/production/prodJour")
public class ProductionJourController {
    private final ProductionJourService service;

    @PostMapping("/createProdJour")
    public ResponseEntity<ProductionJour> createProdJour(@RequestBody @Valid ProductionJourValue productionJour) {
        return ResponseEntity.ok(service.createProdJour(productionJour));
    }

    @GetMapping(path = "/find/by/{id}")
    public ResponseEntity<ProductionJourValue> findProdJourById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProdJour(@PathVariable(name = "id") Long id) {
        this.service.delete(id);
        return ResponseEntity.accepted().build();
    }

    @GetMapping(value = "/find/all", produces = "application/json")
    public ResponseEntity<List<ProductionJourValue>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
}
