package com.gpro.consulting.produit.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "eb_produit")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Produit extends BaseEntity {
    @Id
    @GeneratedValue(generator = "PRODUIT_ID_GENERATOR", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "PRODUIT_SEQ", sequenceName = "PRODUIT_SEQ", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sfpd_id")
    private SousFamilleProduit sousFamilleProduit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "site_id")
    private Site site;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "theme_id")
    private Theme theme;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ligneProduit_id")
    private LigneProduit ligneProduit;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "produit", cascade = CascadeType.REMOVE)
    private List<ProduitGoShippement> produitGoShippements;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "produit", cascade = CascadeType.REMOVE)
    private List<MesureProduit> mesureProduits;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "produit", cascade = CascadeType.REMOVE)
    private List<Taille> tailles;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "produit", cascade = CascadeType.REMOVE)
    private List<Couleur> couleurs;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "produit", cascade = CascadeType.REMOVE)
    private List<PilotageEfficience> pilotageEfficiences;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "produit", cascade = CascadeType.REMOVE)
    private List<ElementTraitement> elementTraitements;

    private Long partieInteresseId;
    private String reference;
    private String designation;
    private boolean ficheBesoin = false;
    private boolean sansTaille = false;
    private boolean sansCouleur = false;
    private String codeConception;
    private Integer quantite;
    private Integer cadence;
    private BigDecimal prixUnitaire;
    private BigDecimal prixMajore;
    private String etat;
}
