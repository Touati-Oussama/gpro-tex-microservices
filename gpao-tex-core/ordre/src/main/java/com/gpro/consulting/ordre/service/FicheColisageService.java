package com.gpro.consulting.ordre.service;

import com.gpro.consulting.ordre.dto.ChaineValue;
import com.gpro.consulting.ordre.dto.FicheColisageValue;
import com.gpro.consulting.ordre.mapper.ChaineMapper;
import com.gpro.consulting.ordre.mapper.FicheColisageMapper;
import com.gpro.consulting.ordre.model.Chaine;
import com.gpro.consulting.ordre.model.FicheColisage;
import com.gpro.consulting.ordre.repository.ChaineRepository;
import com.gpro.consulting.ordre.repository.FicheColisageRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FicheColisageService {

    private final FicheColisageRepository repository;
    private final FicheColisageMapper mapper;

    public FicheColisage createFicheColisage(FicheColisageValue request) {
        return this.repository.save(mapper.toEntity(request));
    }

    public FicheColisageValue findById(Long id) {
        return this.repository.findById(id)
                .map(mapper::toValue)
                .orElseThrow(() -> new EntityNotFoundException(String.format("No fiche found with the provided ID: %s", id)));
    }

    public void delete(Long id) {
        this.repository.deleteById(id);
    }

    public List<FicheColisageValue> findAll() {
        return this.repository.findAll()
                .stream()
                .map(this.mapper::toValue)
                .collect(Collectors.toList());
    }

}
