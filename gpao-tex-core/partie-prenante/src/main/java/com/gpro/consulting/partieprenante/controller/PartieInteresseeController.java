package com.gpro.consulting.partieprenante.controller;

import com.gpro.consulting.partieprenante.dto.PartieInteresseValue;
import com.gpro.consulting.partieprenante.service.PartieInteresseeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("api/operations/pi")
@RequiredArgsConstructor
public class PartieInteresseeController {

    private final PartieInteresseeService service;

    @GetMapping("/hello")
    public String hello(){
        return "Hello world Test CI/CD 10";
    }
    @PostMapping("/creerPi")
    public ResponseEntity<String> createPi(@RequestBody @Valid PartieInteresseValue request) {
        return ResponseEntity.ok(service.createPi(request));
    }

    @PutMapping("/updatePi")
    public ResponseEntity<String> updatePi(@RequestBody @Valid PartieInteresseValue request) {
        return ResponseEntity.ok(service.updatePi(request));
    }

    @GetMapping(path = "/find/by/{id}", produces = "application/json")
    public ResponseEntity<Optional<PartieInteresseValue>> findPiById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping(path = "/AbreviationClient/{id}")
    public ResponseEntity<PartieInteresseValue> getAbbreviationClient(@PathVariable Long id) {
        return ResponseEntity.ok(service.getAbreviationClient(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePi(@PathVariable(name = "id") Long id) {
        this.service.delete(id);
        return ResponseEntity.accepted().build();
    }

    @GetMapping(value = "/find/all", produces = "application/json")
    public ResponseEntity<List<PartieInteresseValue>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping("/recherchePIMulticritere")
    public ResponseEntity<List<PartieInteresseValue>> recherchePIMulticritereOptimiser(@RequestBody PartieInteresseValue request) {
        List<PartieInteresseValue> results = service.findByCriteria(
                request.getSiteId(),
                request.getReference(),
                request.getMatrFiscal(),
                request.getAbreviation(),
                request.getAdresseLiv(),
                request.getModalitePaiement());
        return ResponseEntity.ok(results);
    }
}

