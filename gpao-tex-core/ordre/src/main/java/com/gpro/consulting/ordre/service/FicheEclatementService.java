package com.gpro.consulting.ordre.service;

import com.gpro.consulting.ordre.dto.FicheEclatementValue;
import com.gpro.consulting.ordre.mapper.FicheEclatementMapper;
import com.gpro.consulting.ordre.model.FicheEclatement;
import com.gpro.consulting.ordre.repository.FicheEclatementRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FicheEclatementService {

    private final FicheEclatementRepository repository;
    private final FicheEclatementMapper mapper;

    public FicheEclatement createFicheEclatement(FicheEclatementValue request) {
        return this.repository.save(mapper.toEntity(request));
    }

    public FicheEclatementValue findById(Long id) {
        return this.repository.findById(id)
                .map(mapper::toValue)
                .orElseThrow(() -> new EntityNotFoundException(String.format("No fiche eclatement found with the provided ID: %s", id)));
    }

    public void delete(Long id) {
        this.repository.deleteById(id);
    }

    public List<FicheEclatementValue> findAll() {
        return this.repository.findAll()
                .stream()
                .map(this.mapper::toValue)
                .collect(Collectors.toList());
    }
}
