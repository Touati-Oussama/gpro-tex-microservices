package com.gpro.consulting.ordre.controller;

import com.gpro.consulting.ordre.dto.FicheEclatementValue;
import com.gpro.consulting.ordre.model.FicheEclatement;
import com.gpro.consulting.ordre.service.FicheEclatementService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/order/ficheEclat")
public class FicheEclatementController {

    private final FicheEclatementService service;

    @PostMapping("/creerFicheEclat")
    public ResponseEntity<FicheEclatement> creerFicheEclat(@RequestBody @Valid FicheEclatementValue request) {
        return ResponseEntity.ok(service.createFicheEclatement(request));
    }

    @GetMapping(path = "/find/by/{id}")
    public ResponseEntity<FicheEclatementValue> findFicheEclatById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteFicheEclat(@PathVariable(name = "id") Long id) {
        this.service.delete(id);
        return ResponseEntity.accepted().build();
    }

    @GetMapping(value = "/find/all", produces = "application/json")
    public ResponseEntity<List<FicheEclatementValue>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
}
