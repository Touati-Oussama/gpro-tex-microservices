package com.gpro.consulting.produit.controller;

import com.gpro.consulting.produit.dto.ProduitValue;
import com.gpro.consulting.produit.service.ProduitService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/produit/pd")
@RequiredArgsConstructor
public class ProduitController {

    private final ProduitService service;

    @GetMapping("/hello")
    public String hello(){
        return "Hello, world From Test CI/CD  Test For DevSecOps Integrateffffff !";
    }
    @PostMapping("/createProduit")
    public ResponseEntity<String> createProduit(@RequestBody @Valid ProduitValue request) {
        return ResponseEntity.ok(service.createProduit(request));
    }

    @GetMapping(path = "/find/by/{id}", produces ="application/json")
    public ResponseEntity<ProduitValue> findProduitById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePd(@PathVariable(name = "id") Long id) {
        this.service.delete(id);
        return ResponseEntity.accepted().build();
    }

    @GetMapping(value = "/find/all", produces = "application/json")
    public ResponseEntity<List<ProduitValue>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping(value = "/upload", consumes = {"multipart/form-data"})
    public ResponseEntity<Integer> uploadProducts(
            @RequestPart("file") MultipartFile file
    ) throws IOException {
        return ResponseEntity.ok(service.uploadProduct(file));
    }

    @GetMapping(value = "/export")
    public ResponseEntity<Void> exportCSV(HttpServletResponse response)
            throws Exception {
        service.exportCSV(response);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/rechercheProduitMulticritere")
    public ResponseEntity<List<ProduitValue>> rechercheProduitMulticritere(@RequestBody ProduitValue request) {
        List<ProduitValue> results = service.rechercheProduitMultiCritere(request);
        return ResponseEntity.ok(results);
    }
}

