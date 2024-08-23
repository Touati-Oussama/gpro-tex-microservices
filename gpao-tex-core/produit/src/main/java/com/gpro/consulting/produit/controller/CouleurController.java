package com.gpro.consulting.produit.controller;

import com.gpro.consulting.produit.dto.CouleurValue;
import com.gpro.consulting.produit.service.CouleurService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/produit/couleur")
@RequiredArgsConstructor
public class CouleurController {

    private final CouleurService service;

    @PostMapping("/creerCouleur")
    public ResponseEntity<String> createCouleur(@RequestBody @Valid CouleurValue request) {
        return ResponseEntity.ok(service.createCouleur(request));
    }

    @GetMapping(path = "/find/by/{id}", produces = "application/json")
    public ResponseEntity<CouleurValue> findCouleurById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCouleur(@PathVariable(name = "id") Long id) {
        this.service.delete(id);
        return ResponseEntity.accepted().build();
    }

    @GetMapping(value = "/find/all", produces = "application/json")
    public ResponseEntity<List<CouleurValue>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(value = "/CouleurParProduit/{id}", produces = "application/json")
    public @ResponseBody ResponseEntity<List<CouleurValue>> listCouleurParProduit(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.getCouleursByProduitId(id));
    }

    @PostMapping("/rechercheCouleurMulticritere")
    public ResponseEntity<List<CouleurValue>> rechercheCouleurMulticritere(@RequestBody CouleurValue request) {
        List<CouleurValue> results = service.rechercheCouleurMulticritere(request);
        return ResponseEntity.ok(results);
    }

    @PostMapping(value = "/getAllInList", produces = "application/json")
    public ResponseEntity<List<CouleurValue>> getAllInList(@RequestBody List<Long> ids) {
        List<CouleurValue> results = service.getAllInList(ids);
        return ResponseEntity.ok(results);
    }
}

