package com.gpro.consulting.produit.mapper;

import com.gpro.consulting.produit.dto.CouleurValue;
import com.gpro.consulting.produit.model.Couleur;
import com.gpro.consulting.produit.model.Produit;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CouleurMapper {
    public Couleur toCouleur(CouleurValue request) {
        if (request == null) {
            return null;
        }
        return Couleur.builder()
                .id(request.getId())
                .designation(request.getDesignation())
                .codeCouleur(request.getCodeCouleur())
                .produit(request.getProduitId() != null ?
                        Produit.builder().id(request.getProduitId()).build() : null)
                .build();
    }

    public CouleurValue fromCouleur(Couleur couleur) {
        if (couleur == null) {
            return null;
        }
        return new CouleurValue(
                couleur.getId(),
                couleur.getProduit() != null ? couleur.getProduit().getId() : null,
                couleur.getCodeCouleur(),
                couleur.getDesignation()
        );
    }

    public List<CouleurValue> fromCouleurList(List<Couleur> couleurs) {
        if (couleurs == null) {
            return null;
        }
        return couleurs.stream()
                .map(this::fromCouleur)
                .collect(Collectors.toList());
    }
}
