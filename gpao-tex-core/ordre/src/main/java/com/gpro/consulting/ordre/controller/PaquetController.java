package com.gpro.consulting.ordre.controller;

import com.gpro.consulting.ordre.dto.PaquetValue;
import com.gpro.consulting.ordre.model.Paquet;
import com.gpro.consulting.ordre.service.PaquetService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/order/paquet")
public class PaquetController {
    private final PaquetService service;

    @PostMapping("/creerPaquet")
    public ResponseEntity<Paquet> creerPaquet(@RequestBody @Valid PaquetValue request) {
        return ResponseEntity.ok(service.createPaquet(request));
    }

    @GetMapping(path = "/find/by/{id}")
    public ResponseEntity<PaquetValue> findPaquetById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePaquet(@PathVariable(name = "id") Long id) {
        this.service.delete(id);
        return ResponseEntity.accepted().build();
    }

    @GetMapping(value = "/find/all", produces = "application/json")
    public ResponseEntity<List<PaquetValue>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

}
