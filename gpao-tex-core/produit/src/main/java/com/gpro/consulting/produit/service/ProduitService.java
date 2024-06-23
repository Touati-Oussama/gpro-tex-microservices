package com.gpro.consulting.produit.service;

import com.gpro.consulting.produit.client.PiClient;
import com.gpro.consulting.produit.csv.ProductCsvRepresentation;
import com.gpro.consulting.produit.dto.PartieInteresseValue;
import com.gpro.consulting.produit.dto.ProduitValue;
import com.gpro.consulting.produit.mapper.ProduitMapper;
import com.gpro.consulting.produit.model.Produit;
import com.gpro.consulting.produit.repository.ProduitRepository;
import com.opencsv.CSVWriter;
import com.opencsv.bean.*;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.core.HttpHeaders;
import lombok.AllArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProduitService {
    private final ProduitRepository produitRepository;
    private final ProduitMapper produitMapper;
    private final PiClient piClient;
    private final EntityManager em;

    public String createProduit(ProduitValue request) {
            return produitRepository.save(produitMapper.toProduit(request)).getId().toString();
    }

    public ProduitValue findById(Long id) {
        return this.produitRepository.findById(id)
                .map(produitMapper::fromProduit)
                .orElseThrow(() -> new EntityNotFoundException(String.format("No product found with the provided ID: %s", id)));
    }

    public void delete(Long id) {
        produitRepository.delete(produitRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("No product found with the provided ID: %s", id))));
    }

    public List<ProduitValue> findAll() {
        return this.produitRepository.findAll()
                .stream()
                .map(this.produitMapper::fromProduit)
                .collect(Collectors.toList());
    }

    public Integer uploadProduct(MultipartFile file) throws IOException {
        Set<Produit> produits = parseCsv(file);
        produitRepository.saveAll(produits);
        return produits.size();
    }

    private Set<Produit> parseCsv(MultipartFile file) throws IOException {
        try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            HeaderColumnNameMappingStrategy<ProductCsvRepresentation> strategy =
                    new HeaderColumnNameMappingStrategy<>();
            strategy.setType(ProductCsvRepresentation.class);
            CsvToBean<ProductCsvRepresentation> csvToBean =
                    new CsvToBeanBuilder<ProductCsvRepresentation>(reader)
                            .withMappingStrategy(strategy)
                            .withIgnoreEmptyLine(true)
                            .withIgnoreLeadingWhiteSpace(true)
                            .build();
            return csvToBean.parse()
                    .stream()
                    .map(csvLine -> Produit.builder()
                            .id(csvLine.getId())
                            .partieInteresseId(csvLine.getPartieInteresseId())
                            .reference(csvLine.getReference())
                            .designation(csvLine.getDesignation())
                            .sansCouleur(csvLine.isSansCouleur())
                            .sansTaille(csvLine.isSansTaille())
                            .quantite(csvLine.getQuantite())
                            .prixUnitaire(csvLine.getPrixUnitaire())
                            .build()
                    )
                    .collect(Collectors.toSet());
        }
    }

    public void exportCSV(HttpServletResponse response) throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
        List<Produit> produits = produitRepository.findAll();
        String filename = "Employee-data.csv";
        response.setContentType("text/csv");
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + filename + "\"");
        StatefulBeanToCsv<Produit> writer = new StatefulBeanToCsvBuilder<Produit>(response.getWriter())
                .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER).withSeparator(CSVWriter.DEFAULT_SEPARATOR).withOrderedResults(false)
                .build();
        writer.write(produits);
    }

    public List<ProduitValue> rechercheProduitMultiCritere(ProduitValue produitValue) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Produit> criteriaQuery = criteriaBuilder.createQuery(Produit.class);
        Root<Produit> root = criteriaQuery.from(Produit.class);
        List<Predicate> predicates = new ArrayList<>();
        Optional<PartieInteresseValue> pi = piClient.findPiById(produitValue.getId());
        pi.ifPresent(partieInteresseValue -> predicates.add(criteriaBuilder.equal(root.get("partieInteresse"), partieInteresseValue.getId())));
        if (StringUtils.isNotBlank(produitValue.getReference())) {
            predicates.add(criteriaBuilder.like(root.get("reference"), "%" + produitValue.getReference() + "%"));
        }
        if (StringUtils.isNotBlank(produitValue.getDesignation())) {
            predicates.add(criteriaBuilder.like(root.get("designation"), "%" + produitValue.getDesignation() + "%"));
        }
        if (produitValue.getQuantite() != null) {
            predicates.add(criteriaBuilder.equal(root.get("quantite"), produitValue.getQuantite()));
        }
        if (produitValue.getMesureProduits() != null) {
            predicates.add(criteriaBuilder.equal(root.get("prixUnitaire"), produitValue.getPrixMajore()));
        }
        if (StringUtils.isNotBlank(produitValue.getCodeConception())) {
            predicates.add(criteriaBuilder.equal(root.get("codeConception"), produitValue.getCodeConception()));
        }
        if (produitValue.getThemeId() != null) {
            predicates.add(criteriaBuilder.equal(root.get("theme"), produitValue.getThemeId()));
        }
        if (produitValue.getProduitGoShippements() != null) {
            predicates.add(criteriaBuilder.gt(criteriaBuilder.size(root.<List>get("produitGoShippements")), 0));
        }
        if (produitValue.getPilotageEfficiences() != null) {
            predicates.add(criteriaBuilder.gt(criteriaBuilder.size(root.<List>get("pilotageEfficiences")), 0));
        }
        if (produitValue.getMesureProduits() != null) {
            predicates.add(criteriaBuilder.gt(criteriaBuilder.size(root.<List>get("mesureProduits")), 0));
        }
        if (produitValue.getElementTraitements() != null) {
            predicates.add(criteriaBuilder.gt(criteriaBuilder.size(root.<List>get("elementTraitements")), 0));
        }
        predicates.add(criteriaBuilder.equal(root.get("ficheBesoin"), produitValue.isFicheBesoin()));
        criteriaQuery.select(root).where(predicates.toArray(new Predicate[0]));
        criteriaQuery.orderBy(criteriaBuilder.desc(root.get("id")));
        List<Produit> result = em.createQuery(criteriaQuery).getResultList();
        return produitMapper.fromProduitList(result);
    }
}
