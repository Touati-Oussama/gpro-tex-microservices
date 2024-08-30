package com.gpro.consulting.production.controller;

import com.gpro.consulting.production.dto.ProductionHeureValue;
import com.gpro.consulting.production.model.ProductionHeure;
import com.gpro.consulting.production.model.ProductionJour;
import com.gpro.consulting.production.service.ProductionHeureService;
import com.gpro.consulting.production.service.ProductionJourService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/production/prodHeure")
public class ProductionHeureController {
    private final ProductionHeureService service;

    @GetMapping("/hello")
    public String hello(){
        return "Hello, world From Test CI/CD final test !";
    }
    @PostMapping("/createProdHeure")
    public ResponseEntity<ProductionHeure> createProdHeure(@RequestBody @Valid ProductionHeureValue request) {
        return ResponseEntity.ok(service.createProdHeure(request));
    }

    @GetMapping(path = "/find/by/{id}")
    public ResponseEntity<ProductionHeureValue> findProdHeureById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProdHeure(@PathVariable(name = "id") Long id) {
        this.service.delete(id);
        return ResponseEntity.accepted().build();
    }

    @GetMapping(value = "/find/all", produces = "application/json")
    public ResponseEntity<List<ProductionHeureValue>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
}
