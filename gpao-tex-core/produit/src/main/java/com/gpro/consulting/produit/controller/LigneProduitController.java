package com.gpro.consulting.produit.controller;

import com.gpro.consulting.produit.dto.LigneProduitValue;
import com.gpro.consulting.produit.service.LigneProduitService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/produit/ligne")
@RequiredArgsConstructor
public class LigneProduitController {
    private final LigneProduitService service;

    @PostMapping("/createLigne")
    public ResponseEntity<String> createLigne(@RequestBody @Valid LigneProduitValue request) {
        return ResponseEntity.ok(service.createLigneProduit(request));
    }

    @GetMapping(path = "/find/by/{id}")
    public ResponseEntity<LigneProduitValue> findLigneById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteLigne(@PathVariable(name = "id") Long id) {
        this.service.delete(id);
        return ResponseEntity.accepted().build();
    }

    @GetMapping(value = "/find/all", produces = "application/json")
    public ResponseEntity<List<LigneProduitValue>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
}
