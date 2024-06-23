package com.gpro.consulting.ordre.service;


import com.gpro.consulting.ordre.dto.ColisValue;
import com.gpro.consulting.ordre.mapper.ColisMapper;
import com.gpro.consulting.ordre.model.Colis;
import com.gpro.consulting.ordre.repository.ColisageRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ColisageService {
    private final ColisageRepository repository;
    private final ColisMapper mapper;

    public Colis createColis(ColisValue request) {
        return this.repository.save(mapper.toEntity(request));
    }

    public ColisValue findById(Long id) {
        return this.repository.findById(id)
                .map(mapper::toValue)
                .orElseThrow(() -> new EntityNotFoundException(String.format("No chaine found with the provided ID: %s", id)));
    }

    public void delete(Long id) {
        this.repository.deleteById(id);
    }

    public List<ColisValue> findAll() {
        return this.repository.findAll()
                .stream()
                .map(this.mapper::toValue)
                .collect(Collectors.toList());
    }


}
