package com.gpro.consulting.ordre.service;

import com.gpro.consulting.ordre.dto.PaquetValue;
import com.gpro.consulting.ordre.mapper.PaquetMapper;
import com.gpro.consulting.ordre.model.Paquet;
import com.gpro.consulting.ordre.repository.PaquetRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PaquetService {

    private final PaquetRepository repository;
    private final PaquetMapper mapper;

    public Paquet createPaquet(PaquetValue request) {
        return this.repository.save(mapper.toEntity(request));
    }

    public PaquetValue findById(Long id) {
        return this.repository.findById(id)
                .map(mapper::toValue)
                .orElseThrow(() -> new EntityNotFoundException(String.format("No paquet found with the provided ID: %s", id)));
    }

    public void delete(Long id) {
        this.repository.deleteById(id);
    }

    public List<PaquetValue> findAll() {
        return this.repository.findAll()
                .stream()
                .map(this.mapper::toValue)
                .collect(Collectors.toList());
    }

}
