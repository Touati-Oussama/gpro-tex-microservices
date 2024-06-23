package com.gpro.consulting.produit.controller;

import com.gpro.consulting.produit.dto.PilotageEfficienceValue;
import com.gpro.consulting.produit.model.PilotageEfficience;
import com.gpro.consulting.produit.service.PilotageEfficienceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/produit/pilotage")
@RequiredArgsConstructor
public class PilotageEfficienceController {
    private final PilotageEfficienceService service;

    @PostMapping("/createPilotageEfficience")
    public ResponseEntity<String> createPilotageEfficience(@RequestBody @Valid PilotageEfficienceValue request) {
        return ResponseEntity.ok(service.createPilotageEfficience(request));
    }

    @GetMapping(path = "/find/by/{id}")
    public ResponseEntity<PilotageEfficienceValue> findPeById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePe(@PathVariable(name = "id") Long id) {
        this.service.delete(id);
        return ResponseEntity.accepted().build();
    }

    @GetMapping(value = "/find/all", produces = "application/json")
    public ResponseEntity<List<PilotageEfficienceValue>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
}
