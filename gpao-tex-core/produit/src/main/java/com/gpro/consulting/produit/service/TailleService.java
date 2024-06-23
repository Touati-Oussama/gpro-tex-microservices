package com.gpro.consulting.produit.service;

import com.gpro.consulting.produit.dto.TailleValue;
import com.gpro.consulting.produit.mapper.TailleMapper;
import com.gpro.consulting.produit.model.Produit;
import com.gpro.consulting.produit.model.Taille;
import com.gpro.consulting.produit.repository.ProduitRepository;
import com.gpro.consulting.produit.repository.TailleRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TailleService {
    private final TailleRepository repository;
    private final ProduitRepository produitRepository;
    private final TailleMapper mapper;

    public String createTaille(TailleValue request) {
        var theme = mapper.toTaille(request);
        return repository.save(theme).getId().toString();
    }

    public TailleValue findById(Long id) {
        return this.repository.findById(id)
                .map(mapper::fromTaille)
                .orElseThrow(() -> new EntityNotFoundException(String.format("No taille found with the provided ID: %s", id)));
    }

    public void delete(Long id) {
        this.repository.deleteById(id);
    }

    public List<TailleValue> findAll() {
        return this.repository.findAll()
                .stream()
                .map(this.mapper::fromTaille)
                .collect(Collectors.toList());
    }

    public List<TailleValue> getTailleByProduitId(Long id) {
        return listTailleParProduit(id);
    }

    private List<TailleValue> listTailleParProduit(Long id) {
        Produit produit = produitRepository.findById(id).orElse(null);
        if (produit == null) {
            return Collections.emptyList();
        }
        List<Taille> tailles = produit.getTailles();
        return tailles.stream()
                .map(mapper::fromTaille)
                .collect(Collectors.toList());
    }

    public List<TailleValue> getAllInList(List<Long> ids) {
        if (ids.isEmpty()) {
            return Collections.emptyList();
        }
        return repository.findAllById(ids)
                .stream().map(mapper::fromTaille)
                .collect(Collectors.toList());
    }
}
