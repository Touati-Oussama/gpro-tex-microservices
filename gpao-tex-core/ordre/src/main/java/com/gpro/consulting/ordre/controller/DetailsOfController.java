package com.gpro.consulting.ordre.controller;

import com.gpro.consulting.ordre.dto.DetailOfValue;
import com.gpro.consulting.ordre.model.DetailOf;
import com.gpro.consulting.ordre.service.DetailsOfService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/order/detailsOf")
public class DetailsOfController {

    private final DetailsOfService service;

    @PostMapping("/creerDetailOf")
    public ResponseEntity<String> creerDetailOf(@RequestBody @Valid DetailOfValue request) {
        return ResponseEntity.ok(service.createDetailOf(request));
    }

    @GetMapping(path = "/find/by/{id}")
    public ResponseEntity<DetailOfValue> findDetailOfById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteDetailOf(@PathVariable(name = "id") Long id) {
        this.service.delete(id);
        return ResponseEntity.accepted().build();
    }

    @GetMapping(value = "/find/all", produces = "application/json")
    public ResponseEntity<List<DetailOfValue>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
}
