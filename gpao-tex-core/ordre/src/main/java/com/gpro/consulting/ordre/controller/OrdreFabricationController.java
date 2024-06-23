package com.gpro.consulting.ordre.controller;

import com.gpro.consulting.ordre.dto.CouleurValue;
import com.gpro.consulting.ordre.dto.OrdreFabricationValue;
import com.gpro.consulting.ordre.service.OrdreFabricationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("api/order/of")
public class OrdreFabricationController {

    private final OrdreFabricationService service;

    @PostMapping("/createOf")
    public ResponseEntity<String> createOf(@RequestBody @Valid OrdreFabricationValue request) {
        return ResponseEntity.ok(service.createOf(request));
    }

    @GetMapping(path = "/find/by/{id}")
    public ResponseEntity<OrdreFabricationValue> findOfById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteOf(@PathVariable(name = "id") Long id) {
        this.service.delete(id);
        return ResponseEntity.accepted().build();
    }

    @GetMapping(value = "/find/all", produces = "application/json")
    public ResponseEntity<List<OrdreFabricationValue>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(value = "/getCouleurOf:{ofId}", produces = "application/json")
    public ResponseEntity<List<CouleurValue>> listeCouleurOf(@PathVariable Long ofId) {
        return ResponseEntity.ok(service.listeCouleurOf(ofId));
    }

    @GetMapping(value = "/getTailleOf:{ofId}", produces = "application/json")
    public ResponseEntity<List<CouleurValue>> listeTailleOf(@PathVariable Long ofId) {
        return ResponseEntity.ok(service.listeTailleOf(ofId));
    }
}
