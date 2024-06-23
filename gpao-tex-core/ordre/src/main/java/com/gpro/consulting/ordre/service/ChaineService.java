package com.gpro.consulting.ordre.service;

import com.gpro.consulting.ordre.dto.ChaineValue;
import com.gpro.consulting.ordre.mapper.ChaineMapper;
import com.gpro.consulting.ordre.model.Chaine;
import com.gpro.consulting.ordre.repository.ChaineRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ChaineService {
    private final ChaineRepository repository;
    private final ChaineMapper mapper;

    public Chaine createChaine(ChaineValue request) {
        return this.repository.save(mapper.toEntity(request));
    }

    public ChaineValue findById(Long id) {
        return this.repository.findById(id)
                .map(mapper::toValue)
                .orElseThrow(() -> new EntityNotFoundException(String.format("No chaine found with the provided ID: %s", id)));
    }

    public void delete(Long id) {
        this.repository.deleteById(id);
    }

    public List<ChaineValue> findAll() {
        return this.repository.findAll()
                .stream()
                .map(this.mapper::toValue)
                .collect(Collectors.toList());
    }
}
