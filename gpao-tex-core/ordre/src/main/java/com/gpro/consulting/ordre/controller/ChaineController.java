package com.gpro.consulting.ordre.controller;

import com.gpro.consulting.ordre.dto.ChaineValue;
import com.gpro.consulting.ordre.model.Chaine;
import com.gpro.consulting.ordre.service.ChaineService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/order/chaine")
public class ChaineController {
    private final ChaineService service;

    @PostMapping("/creerChaine")
    public ResponseEntity<Chaine> createChaine(@RequestBody @Valid ChaineValue request) {
        return ResponseEntity.ok(service.createChaine(request));
    }

    @GetMapping(path = "/find/by/{id}", produces = "application/json")
    public ResponseEntity<ChaineValue> findChaineById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteChaine(@PathVariable(name = "id") Long id) {
        this.service.delete(id);
        return ResponseEntity.accepted().build();
    }

    @GetMapping(value = "/find/all", produces = "application/json")
    public ResponseEntity<List<ChaineValue>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
}