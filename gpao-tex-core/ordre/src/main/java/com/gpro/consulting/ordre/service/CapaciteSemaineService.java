package com.gpro.consulting.ordre.service;

import com.gpro.consulting.ordre.dto.CapaciteSemaineValue;
import com.gpro.consulting.ordre.mapper.CapaciteSemaineMapper;
import com.gpro.consulting.ordre.model.CapaciteSemaine;
import com.gpro.consulting.ordre.repository.CapaciteSemaineRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CapaciteSemaineService {

    private final CapaciteSemaineRepository repository;
    private final CapaciteSemaineMapper mapper;

    public CapaciteSemaine createCs(CapaciteSemaineValue request) {
        return this.repository.save(mapper.toCs(request));
    }

    public CapaciteSemaineValue findById(Long id) {
        return this.repository.findById(id)
                .map(mapper::fromCs)
                .orElseThrow(() -> new EntityNotFoundException(String.format("No cs found with the provided ID: %s", id)));
    }

    public void delete(Long id) {
        this.repository.deleteById(id);
    }

    public List<CapaciteSemaineValue> findAll() {
        return this.repository.findAll()
                .stream()
                .map(this.mapper::fromCs)
                .collect(Collectors.toList());
    }
}
