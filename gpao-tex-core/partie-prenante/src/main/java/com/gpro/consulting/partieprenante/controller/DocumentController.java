package com.gpro.consulting.partieprenante.controller;

import com.gpro.consulting.partieprenante.dto.DocumentPiValue;
import com.gpro.consulting.partieprenante.service.DocumentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/operations/doc")
@RequiredArgsConstructor
public class DocumentController {

    private final DocumentService service;

    @PostMapping("/createDoc")
    public ResponseEntity<String> createDoc(@RequestBody @Valid DocumentPiValue request) {
        return ResponseEntity.ok(service.createDoc(request));
    }

    @GetMapping(path = "/find/by/{id}")
    public ResponseEntity<DocumentPiValue> findPiById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePi(@PathVariable(name = "id") Long id) {
        this.service.delete(id);
        return ResponseEntity.accepted().build();
    }

    @GetMapping(value = "/find/all", produces = "application/json")
    public ResponseEntity<List<DocumentPiValue>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

}

