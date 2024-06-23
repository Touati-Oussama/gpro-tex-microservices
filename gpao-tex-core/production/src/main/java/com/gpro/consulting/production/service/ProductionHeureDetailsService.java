package com.gpro.consulting.production.service;

import com.gpro.consulting.production.dto.ProductionHeureDetailsValue;
import com.gpro.consulting.production.mapper.ProductionHeureDetailsMapper;
import com.gpro.consulting.production.model.ProductionHeureDetails;
import com.gpro.consulting.production.repository.ProductionHeureDetailsRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductionHeureDetailsService {

    private final ProductionHeureDetailsRepository repository;
    private final ProductionHeureDetailsMapper mapper;

    public ProductionHeureDetails createProductionHeureDetails(ProductionHeureDetailsValue request) {
        return this.repository.save(mapper.toProductionHeureDetails(request));
    }

    public ProductionHeureDetailsValue findById(Long id) {
        return this.repository.findById(id)
                .map(mapper::fromProductionHeureDetails)
                .orElseThrow(() -> new EntityNotFoundException(String.format("No prod details found with the provided ID: %s", id)));
    }

    public void delete(Long id) {
        this.repository.deleteById(id);
    }

    public List<ProductionHeureDetailsValue> findAll() {
        return this.repository.findAll()
                .stream()
                .map(this.mapper::fromProductionHeureDetails)
                .collect(Collectors.toList());
    }
}
