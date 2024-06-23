package com.gpro.consulting.produit.service;

import com.gpro.consulting.produit.dto.PilotageEfficienceValue;
import com.gpro.consulting.produit.mapper.PilotageEfficienceMapper;
import com.gpro.consulting.produit.repository.PilotageEfficienceRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PilotageEfficienceService {
    private final PilotageEfficienceRepository repository;
    private final PilotageEfficienceMapper mapper;

    public String createPilotageEfficience(PilotageEfficienceValue request) {
        var pe = mapper.toPilotageEfficience(request);
        return repository.save(pe).getId().toString();
    }

    public PilotageEfficienceValue findById(Long id) {
        return this.repository.findById(id)
                .map(mapper::fromPilotageEfficience)
                .orElseThrow(() -> new EntityNotFoundException(String.format("No pilotage found with the provided ID: %s", id)));
    }

    public void delete(Long id) {
        this.repository.deleteById(id);
    }

    public List<PilotageEfficienceValue> findAll() {
        return this.repository.findAll()
                .stream()
                .map(this.mapper::fromPilotageEfficience)
                .collect(Collectors.toList());
    }
}
