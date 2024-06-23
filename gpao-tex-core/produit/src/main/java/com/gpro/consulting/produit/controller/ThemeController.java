package com.gpro.consulting.produit.controller;

import com.gpro.consulting.produit.dto.ThemeValue;
import com.gpro.consulting.produit.model.Produit;
import com.gpro.consulting.produit.service.ThemeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/produit/theme")
@RequiredArgsConstructor
public class ThemeController {
    private final ThemeService service;

    @PostMapping("/createTheme")
    public ResponseEntity<String> createTheme(@RequestBody @Valid ThemeValue request) {
        return ResponseEntity.ok(service.createTheme(request));
    }

    @GetMapping(path = "/find/by/{id}")
    public ResponseEntity<ThemeValue> findThemeById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTheme(@PathVariable(name = "id") Long id) {
        this.service.delete(id);
        return ResponseEntity.accepted().build();
    }

    @GetMapping(value = "/find/all", produces = "application/json")
    public ResponseEntity<List<ThemeValue>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping("/rechercheThemeMulticritere")
    public ResponseEntity<List<ThemeValue>> rechercheThemeMulticritere(@RequestParam String designation, @RequestParam Produit produit, @RequestParam String spl) {
        List<ThemeValue> results = service.rechercheThemeMultiCritere(designation, produit, spl);
        return ResponseEntity.ok(results);
    }
}
