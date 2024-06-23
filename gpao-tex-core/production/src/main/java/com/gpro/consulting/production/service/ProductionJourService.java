package com.gpro.consulting.production.service;

import com.gpro.consulting.production.dto.ProductionJourValue;
import com.gpro.consulting.production.mapper.ProductionJourMapper;
import com.gpro.consulting.production.model.ProductionJour;
import com.gpro.consulting.production.repository.ProductionJourRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductionJourService {
    private final ProductionJourRepository repository;
    private final ProductionJourMapper mapper;

    public ProductionJour createProdJour(ProductionJourValue request) {
        return this.repository.save(mapper.toEntity(request));
    }

    public ProductionJourValue findById(Long id) {
        return this.repository.findById(id)
                .map(mapper::toValue)
                .orElseThrow(() -> new EntityNotFoundException(String.format("No prod jour found with the provided ID: %s", id)));
    }

    public void delete(Long id) {
        this.repository.deleteById(id);
    }

    public List<ProductionJourValue> findAll() {
        return this.repository.findAll()
                .stream()
                .map(this.mapper::toValue)
                .collect(Collectors.toList());
    }
}
