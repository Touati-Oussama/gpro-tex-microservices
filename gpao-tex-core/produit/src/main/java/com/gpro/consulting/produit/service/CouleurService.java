package com.gpro.consulting.produit.service;

import com.gpro.consulting.produit.dto.CouleurValue;
import com.gpro.consulting.produit.mapper.CouleurMapper;
import com.gpro.consulting.produit.model.Couleur;
import com.gpro.consulting.produit.model.Produit;
import com.gpro.consulting.produit.repository.CouleurRepository;
import com.gpro.consulting.produit.repository.ProduitRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CouleurService {

    private final CouleurRepository repository;
    private final CouleurMapper couleurMapper;
    private final ProduitRepository produitRepository;
    private final EntityManager em;

    public String createCouleur(CouleurValue request) {
        var couleur = couleurMapper.toCouleur(request);
        return repository.save(couleur).getId().toString();
    }

    public CouleurValue findById(Long id) {
        return this.repository.findById(id)
                .map(couleurMapper::fromCouleur)
                .orElseThrow(() -> new EntityNotFoundException(String.format("No couleur found with the provided ID: %s", id)));
    }

    public void delete(Long id) {
        this.repository.deleteById(id);
    }

    public List<CouleurValue> findAll() {
        return this.repository.findAll()
                .stream()
                .map(this.couleurMapper::fromCouleur)
                .collect(Collectors.toList());
    }

    public List<CouleurValue> rechercheCouleurMulticritere(CouleurValue couleurValue) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Couleur> criteriaQuery = criteriaBuilder.createQuery(Couleur.class);
        Root<Couleur> root = criteriaQuery.from(Couleur.class);
        List<Predicate> predicates = new ArrayList<>();
        if (StringUtils.isNotBlank(couleurValue.getDesignation())) {
            predicates.add(criteriaBuilder.like(root.get("designation"), "%" + couleurValue.getDesignation() + "%"));
        }
        if (couleurValue.getProduitId() != null) {
            predicates.add(criteriaBuilder.equal(root.get("produit"), couleurValue.getProduitId()));
        }
        if (couleurValue.getCodeCouleur() != null) {
            predicates.add(criteriaBuilder.equal(root.get("codeCouleur"), couleurValue.getCodeCouleur()));
        }
        criteriaQuery.select(root).where(predicates.toArray(new Predicate[0]));
        criteriaQuery.orderBy(criteriaBuilder.desc(root.get("id")));
        List<Couleur> result = em.createQuery(criteriaQuery).getResultList();
        return couleurMapper.fromCouleurList(result);
    }

    public List<CouleurValue> getCouleursByProduitId(Long id) {
        return listCouleurParProduit(id);
    }

    private List<CouleurValue> listCouleurParProduit(Long id) {
        Produit produit = produitRepository.findById(id).orElse(null);
        if (produit == null) {
            return Collections.emptyList();
        }
        List<Couleur> couleurs = produit.getCouleurs();
        return couleurs.stream()
                .map(couleurMapper::fromCouleur)
                .collect(Collectors.toList());
    }

    public List<CouleurValue> getAllInList(List<Long> ids) {
        if (ids.isEmpty()) {
            return Collections.emptyList();
        }
        return repository.findAllById(ids)
                .stream().map(couleurMapper::fromCouleur)
                .collect(Collectors.toList());
    }
}
