package com.gpro.consulting.ordre.controller;

import com.gpro.consulting.ordre.dto.CapaciteSemaineValue;
import com.gpro.consulting.ordre.model.CapaciteSemaine;
import com.gpro.consulting.ordre.service.CapaciteSemaineService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/order/capaciteSemaine")
public class CapaciteSemaineController {

    private final CapaciteSemaineService service;


    @PostMapping("/creerCs")
    public ResponseEntity<CapaciteSemaine> createCs(@RequestBody @Valid CapaciteSemaineValue request) {
        return ResponseEntity.ok(service.createCs(request));
    }

    @GetMapping(path = "/find/by/{id}")
    public ResponseEntity<CapaciteSemaineValue> findCsById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCs(@PathVariable(name = "id") Long id) {
        this.service.delete(id);
        return ResponseEntity.accepted().build();
    }

    @GetMapping(value = "/find/all", produces = "application/json")
    public ResponseEntity<List<CapaciteSemaineValue>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
}
