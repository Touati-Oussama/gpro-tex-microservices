package com.gpro.consulting.production.service;

import com.gpro.consulting.production.dto.ProductionHeureValue;
import com.gpro.consulting.production.mapper.ProductionHeureMapper;
import com.gpro.consulting.production.model.ProductionHeure;
import com.gpro.consulting.production.repository.ProductionHeureRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductionHeureService {
    private final ProductionHeureRepository repository;
    private final ProductionHeureMapper mapper;

    public ProductionHeure createProdHeure(ProductionHeureValue request) {
        return this.repository.save(mapper.toProductionHeure(request));
    }

    public ProductionHeureValue findById(Long id) {
        return this.repository.findById(id)
                .map(mapper::fromProductionHeure)
                .orElseThrow(() -> new EntityNotFoundException(String.format("No prod heure found with the provided ID: %s", id)));
    }

    public void delete(Long id) {
        this.repository.deleteById(id);
    }

    public List<ProductionHeureValue> findAll() {
        return this.repository.findAll()
                .stream()
                .map(this.mapper::fromProductionHeure)
                .collect(Collectors.toList());
    }
}
