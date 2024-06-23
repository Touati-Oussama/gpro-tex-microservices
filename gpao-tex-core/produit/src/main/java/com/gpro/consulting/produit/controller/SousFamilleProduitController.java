package com.gpro.consulting.produit.controller;

import com.gpro.consulting.produit.dto.SousFamilleValue;
import com.gpro.consulting.produit.service.SousFamilleProduitService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/produit/sfpd")
@RequiredArgsConstructor
public class SousFamilleProduitController {
    private final SousFamilleProduitService service;
    @PostMapping("/creerSfpd")
    public ResponseEntity<String> createCouleur(@RequestBody @Valid SousFamilleValue request) {
        return ResponseEntity.ok(service.createSfPd(request));
    }

    @GetMapping(path = "/find/by/{id}")
    public ResponseEntity<SousFamilleValue> findCouleurById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCouleur(@PathVariable Long id) {
        this.service.delete(id);
        return ResponseEntity.accepted().build();
    }

    @GetMapping(value = "/find/all", produces = "application/json")
    public ResponseEntity<List<SousFamilleValue>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
}
