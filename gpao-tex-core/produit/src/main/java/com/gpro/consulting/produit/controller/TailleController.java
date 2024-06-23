package com.gpro.consulting.produit.controller;

import com.gpro.consulting.produit.dto.TailleValue;
import com.gpro.consulting.produit.service.TailleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/produit/taille")
@RequiredArgsConstructor
public class TailleController {
    private final TailleService service;

    @PostMapping("/createTaille")
    public ResponseEntity<String> createTaille(@RequestBody @Valid TailleValue request) {
        return ResponseEntity.ok(service.createTaille(request));
    }

    @GetMapping(path = "/find/by/{id}")
    public ResponseEntity<TailleValue> findTailleById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTaille(@PathVariable(name = "id") Long id) {
        this.service.delete(id);
        return ResponseEntity.accepted().build();
    }

    @GetMapping(value = "/find/all", produces = "application/json")
    public ResponseEntity<List<TailleValue>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(value = "/TailleParProduit/{id}", produces = "application/json")
    public @ResponseBody ResponseEntity<List<TailleValue>> listTailleParProduit(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.getTailleByProduitId(id));
    }

    @PostMapping("/getAllInList")
    public ResponseEntity<List<TailleValue>> getAllInList(@RequestBody List<Long> ids) {
        List<TailleValue> results = service.getAllInList(ids);
        return ResponseEntity.ok(results);
    }
}
