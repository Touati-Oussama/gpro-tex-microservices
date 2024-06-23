package com.gpro.consulting.partieprenante.controller;

import com.gpro.consulting.partieprenante.dto.RepresentantValue;
import com.gpro.consulting.partieprenante.service.RepresentantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/operations/rep")
@RequiredArgsConstructor
public class RepresentantController {

    private final RepresentantService service;

    @PostMapping("/createRep")
    public ResponseEntity<String> createRep(@RequestBody @Valid RepresentantValue request) {
        return ResponseEntity.ok(service.createRep(request));
    }

    @GetMapping(path = "/find/by/{id}")
    public ResponseEntity<RepresentantValue> findPiById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePi(@PathVariable(name = "id") Long id) {
        this.service.delete(id);
        return ResponseEntity.accepted().build();
    }

    @GetMapping(value = "/find/all", produces = "application/json")
    public ResponseEntity<List<RepresentantValue>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
}

