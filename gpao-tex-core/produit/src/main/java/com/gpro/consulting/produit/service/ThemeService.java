package com.gpro.consulting.produit.service;

import com.gpro.consulting.produit.dto.ThemeValue;
import com.gpro.consulting.produit.mapper.ThemeMapper;
import com.gpro.consulting.produit.model.Produit;
import com.gpro.consulting.produit.repository.ThemeRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ThemeService {
    private final ThemeRepository repository;
    private final ThemeMapper mapper;

    public String createTheme(ThemeValue request) {
        var theme = mapper.toTheme(request);
        return repository.save(theme).getId().toString();
    }

    public ThemeValue findById(Long id) {
        return this.repository.findById(id)
                .map(mapper::fromTheme)
                .orElseThrow(() -> new EntityNotFoundException(String.format("No taille found with the provided ID: %s", id)));
    }

    public void delete(Long id) {
        this.repository.deleteById(id);
    }

    public List<ThemeValue> findAll() {
        return this.repository.findAll()
                .stream()
                .map(this.mapper::fromTheme)
                .collect(Collectors.toList());
    }

    public List<ThemeValue> rechercheThemeMultiCritere(String designation, Produit produit, String spl) {
        return this.repository.rechercheThemeMultiCritere(designation, produit, spl)
                .stream()
                .map(this.mapper::fromTheme)
                .collect(Collectors.toList());
    }
}
