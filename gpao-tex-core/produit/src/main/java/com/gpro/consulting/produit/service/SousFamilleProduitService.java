package com.gpro.consulting.produit.service;

import com.gpro.consulting.produit.dto.SousFamilleValue;
import com.gpro.consulting.produit.mapper.SousFamilleMapper;
import com.gpro.consulting.produit.repository.SousFamilleProduitRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SousFamilleProduitService {
    private final SousFamilleProduitRepository repository;
    private final SousFamilleMapper mapper;

    public String createSfPd(SousFamilleValue request) {
        var sfPd = mapper.toSousFamilleProduit(request);
        return repository.save(sfPd).getId().toString();
    }

    public SousFamilleValue findById(Long id) {
        return this.repository.findById(id)
                .map(mapper::fromSousFamilleProduit)
                .orElseThrow(() -> new EntityNotFoundException(String.format("No sf found with the provided ID: %s", id)));
    }

    public void delete(Long id) {
        this.repository.deleteById(id);
    }

    public List<SousFamilleValue> findAll() {
        return this.repository.findAll()
                .stream()
                .map(this.mapper::fromSousFamilleProduit)
                .collect(Collectors.toList());
    }
}
