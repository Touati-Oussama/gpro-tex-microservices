package com.gpro.consulting.produit.service;

import com.gpro.consulting.produit.dto.LigneProduitValue;
import com.gpro.consulting.produit.mapper.LigneProduitMapper;
import com.gpro.consulting.produit.repository.LigneProduitRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class LigneProduitService {
    private final LigneProduitRepository repository;
    private final LigneProduitMapper mapper;

    public String createLigneProduit(LigneProduitValue request) {
        var pe = mapper.toLigneProduit(request);
        return repository.save(pe).getId().toString();
    }

    public LigneProduitValue findById(Long id) {
        return this.repository.findById(id)
                .map(mapper::fromLigneProduit)
                .orElseThrow(() -> new EntityNotFoundException(String.format("No Ligne produit found with the provided ID: %s", id)));
    }

    public void delete(Long id) {
        this.repository.deleteById(id);
    }

    public List<LigneProduitValue> findAll() {
        return this.repository.findAll()
                .stream()
                .map(this.mapper::fromLigneProduit)
                .collect(Collectors.toList());
    }
}
