package com.gpro.consulting.produit.service;

import com.gpro.consulting.produit.dto.SiteValue;
import com.gpro.consulting.produit.mapper.SiteMapper;
import com.gpro.consulting.produit.model.Site;
import com.gpro.consulting.produit.repository.SiteRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SiteService {
    private final SiteRepository repository;
    private final SiteMapper mapper;

    public String createSite(SiteValue request) {
        var site = mapper.toSite(request);
        return repository.save(site).getId().toString();
    }

    public SiteValue findById(Long id) {
        return this.repository.findById(id)
                .map(mapper::fromSite)
                .orElseThrow(() -> new EntityNotFoundException(String.format("No site found with the provided ID: %s", id)));
    }

    public void delete(Long id) {
        this.repository.deleteById(id);
    }

    public List<SiteValue> findAll() {
        return this.repository.findAll()
                .stream()
                .map(this.mapper::fromSite)
                .collect(Collectors.toList());
    }

    public List<SiteValue> findAllBySitePrincipal() {
        List<Site> site = repository.findAllBySitePrincipal();
        return mapper.fromSiteList(site);
    }
}
