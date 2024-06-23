package com.gpro.consulting.ordre.service;

import com.gpro.consulting.ordre.dto.DetailOfValue;
import com.gpro.consulting.ordre.mapper.DetailOfMapper;
import com.gpro.consulting.ordre.repository.DetailOfRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DetailsOfService {

    private final DetailOfRepository repository;
    private final DetailOfMapper mapper;

    public String createDetailOf(DetailOfValue request) {
        var detailOf = mapper.toDetailOf(request);
        return repository.save(detailOf).getId().toString();
    }

    public DetailOfValue findById(Long id) {
        return this.repository.findById(id)
                .map(mapper::fromDetailOf)
                .orElseThrow(() -> new EntityNotFoundException(String.format("No chaine found with the provided ID: %s", id)));
    }

    public void delete(Long id) {
        this.repository.deleteById(id);
    }

    public List<DetailOfValue> findAll() {
        return this.repository.findAll()
                .stream()
                .map(this.mapper::fromDetailOf)
                .collect(Collectors.toList());
    }

}
