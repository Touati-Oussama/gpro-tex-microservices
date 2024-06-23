package com.gpro.consulting.ordre.controller;

import com.gpro.consulting.ordre.dto.FicheColisageValue;
import com.gpro.consulting.ordre.model.FicheColisage;
import com.gpro.consulting.ordre.service.FicheColisageService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/order/ficheColi")
public class FicheColisageController {

    private final FicheColisageService service;

    @PostMapping("/creerFiche")
    public ResponseEntity<FicheColisage> creerFiche(@RequestBody @Valid FicheColisageValue request) {
        return ResponseEntity.ok(service.createFicheColisage(request));
    }

    @GetMapping(path = "/find/by/{id}")
    public ResponseEntity<FicheColisageValue> findFicheColisById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteFicheColis(@PathVariable(name = "id") Long id) {
        this.service.delete(id);
        return ResponseEntity.accepted().build();
    }

    @GetMapping(value = "/find/all", produces = "application/json")
    public ResponseEntity<List<FicheColisageValue>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
}
