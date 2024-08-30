package com.gpro.consulting.produit.model;

import com.gpro.consulting.produit.dto.PartieInteresseValue;
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
    @JoinColumn(name = "eb_sfprod_id")
    private SousFamilleProduit sousFamilleProduit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "com_site_id")
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

    @Transient
    private PartieInteresseValue partieInteresse;

    @Column(name = "pi_pi_id")
    private Long partieInteresseId;
    private String reference;
    private String designation;
    @Column(name = "fiche_besoin")
    private boolean ficheBesoin = false;
    @Column(name = "sans_taille")
    private boolean sansTaille = false;
    @Column(name = "sans_couleur")
    private boolean sansCouleur = false;
    @Column(name = "code_conception")
    private String codeConception;
    private Integer quantite;
    private Integer cadence;
    @Column(name = "prix_unitaire")
    private BigDecimal prixUnitaire;
    @Column(name = "prix_majore")
    private BigDecimal prixMajore;
    private String etat;
}
