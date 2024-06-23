package com.gpro.consulting.ordre.controller;

import com.gpro.consulting.ordre.dto.ColisValue;
import com.gpro.consulting.ordre.model.Colis;
import com.gpro.consulting.ordre.service.ColisageService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/order/colis")
public class ColisController {
    private final ColisageService service;

    @PostMapping("/creerChaine")
    public ResponseEntity<Colis> createColis(@RequestBody @Valid ColisValue request) {
        return ResponseEntity.ok(service.createColis(request));
    }

    @GetMapping(path = "/find/by/{id}")
    public ResponseEntity<ColisValue> findColisById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteColis(@PathVariable(name = "id") Long id) {
        this.service.delete(id);
        return ResponseEntity.accepted().build();
    }

    @GetMapping(value = "/find/all", produces = "application/json")
    public ResponseEntity<List<ColisValue>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
}
