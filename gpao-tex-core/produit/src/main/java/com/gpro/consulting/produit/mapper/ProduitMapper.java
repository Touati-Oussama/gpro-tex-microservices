package com.gpro.consulting.produit.mapper;

import com.gpro.consulting.produit.dto.ProduitValue;
import com.gpro.consulting.produit.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProduitMapper {
    private final ProduitGoShippementMapper produitGoShippementMapper;
    private final MesureProduitMapper mesureProduitMapper;
    private final TailleMapper tailleMapper;
    private final CouleurMapper couleurMapper;
    private final PilotageEfficienceMapper pilotageEfficienceMapper;
    private final ElementTraitementMapper elementTraitementMapper;

    public Produit toProduit(ProduitValue request) {
        if (request == null) {
            return null;
        }

        return Produit.builder()
                .id(request.getId())
                .sousFamilleProduit(SousFamilleProduit.builder().id(request.getSousFamilleProduitId()).build())
                .site(Site.builder().id(request.getSiteId()).build())
                .ligneProduit(LigneProduit.builder().id(request.getLigneProduitId()).build())
                .theme(Theme.builder().id(request.getThemeId()).build())
                .produitGoShippements(request.getProduitGoShippements() != null ? request.getProduitGoShippements().stream()
                        .map(produitGoShippementMapper::toProduitGoShippement)
                        .collect(Collectors.toList()) : null)
                .mesureProduits(request.getMesureProduits() != null ? request.getMesureProduits().stream()
                        .map(mesureProduitMapper::toMesureProduit)
                        .collect(Collectors.toList()) : null)
                .tailles(request.getTailles() != null ? request.getTailles().stream()
                        .map(tailleMapper::toTaille)
                        .collect(Collectors.toList()) : null)
                .couleurs(request.getCouleurs() != null ? request.getCouleurs().stream()
                        .map(couleurMapper::toCouleur)
                        .collect(Collectors.toList()) : null)
                .pilotageEfficiences(request.getPilotageEfficiences() != null ? request.getPilotageEfficiences().stream()
                        .map(pilotageEfficienceMapper::toPilotageEfficience)
                        .collect(Collectors.toList()) : null)
                .elementTraitements(request.getElementTraitements() != null ? request.getElementTraitements().stream()
                        .map(elementTraitementMapper::toElementTraitement)
                        .collect(Collectors.toList()) : null)
                .partieInteresseId(request.getPartieInteresseId())
                .reference(request.getReference())
                .designation(request.getDesignation())
                .ficheBesoin(request.isFicheBesoin())
                .sansTaille(request.isSansTaille())
                .sansCouleur(request.isSansCouleur())
                .codeConception(request.getCodeConception())
                .quantite(request.getQuantite())
                .cadence(request.getCadence())
                .prixUnitaire(request.getPrixUnitaire())
                .prixMajore(request.getPrixMajore())
                .etat(request.getEtat())
                .build();
    }

    public ProduitValue fromProduit(Produit produit) {
        if (produit == null) {
            return null;
        }

        return new ProduitValue(
                produit.getId(),
                produit.getSousFamilleProduit() != null ? produit.getSousFamilleProduit().getId() : null,
                produit.getSite() != null ? produit.getSite().getId() : null,
                produit.getLigneProduit() != null ? produit.getLigneProduit().getId() : null,
                produit.getTheme() != null ? produit.getTheme().getId() : null,
                getConvertedList(produit.getProduitGoShippements(), produitGoShippementMapper::fromProduitGoShippement),
                getConvertedList(produit.getMesureProduits(), mesureProduitMapper::fromMesureProduit),
                getConvertedList(produit.getTailles(), tailleMapper::fromTaille),
                getConvertedList(produit.getCouleurs(), couleurMapper::fromCouleur),
                getConvertedList(produit.getPilotageEfficiences(), pilotageEfficienceMapper::fromPilotageEfficience),
                getConvertedList(produit.getElementTraitements(), elementTraitementMapper::fromElementTraitement),
                produit.getPartieInteresseId(),
                produit.getReference(),
                produit.getDesignation(),
                produit.isFicheBesoin(),
                produit.isSansTaille(),
                produit.isSansCouleur(),
                produit.getCodeConception(),
                produit.getQuantite(),
                produit.getCadence(),
                produit.getPrixUnitaire(),
                produit.getPrixMajore(),
                produit.getEtat(),
                produit.getPartieInteresse()
        );
    }

    private <T, V> List<V> getConvertedList(List<T> sourceList, Function<T, V> mapper) {
        return sourceList == null ? Collections.emptyList() : sourceList.stream()
                .map(mapper)
                .collect(Collectors.toList());
    }

    public List<ProduitValue> fromProduitList(List<Produit> produits) {
        if (produits == null) {
            return null;
        }
        return produits.stream()
                .map(this::fromProduit)
                .collect(Collectors.toList());
    }
}


