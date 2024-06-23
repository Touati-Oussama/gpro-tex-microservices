package com.gpro.consulting.partieprenante.service;

import com.gpro.consulting.partieprenante.dto.RepresentantValue;
import com.gpro.consulting.partieprenante.mapper.RepresentantMapper;
import com.gpro.consulting.partieprenante.repository.RepresentantRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RepresentantService {

    private final RepresentantRepository repository;
    private final RepresentantMapper docMapper;

    public String createRep(RepresentantValue request) {
        var rep = docMapper.toRepresentant(request);
        return repository.save(rep).getId().toString();
    }

    public RepresentantValue findById(Long id) {
        return docMapper.toRepresentantValue(repository.findById(id).orElseThrow(() ->
                new EntityNotFoundException(String.format("No pi found with the provided ID: %s", id))));
    }

    public void delete(Long id) {
        this.repository.deleteById(id);
    }

    public List<RepresentantValue> findAll() {
        return this.repository.findAll()
                .stream()
                .map(docMapper::toRepresentantValue)
                .collect(Collectors.toList());
    }
}
