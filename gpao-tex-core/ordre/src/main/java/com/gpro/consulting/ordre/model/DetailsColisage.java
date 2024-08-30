package com.gpro.consulting.ordre.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "gp_details_colis")
@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DetailsColisage extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "gp_fiche_id")
    private FicheColisage ficheColisage;

    @Id
    @GeneratedValue(generator = "DETAILS_COLIS_ID_GENERATOR", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "DETAILS_COLIS_SEQ", sequenceName = "DETAILS_COLIS_SEQ", allocationSize = 1)
    private Long id;
    @Column(name = "eb_couleur_id")
    private Long couleurId;
    @Column(name = "eb_taille_id")
    private Long tailleId;
    @Column(name = "quantite_restante")
    private Long quantiteRestante;
    private Long quantite;
    private Long pcb;
    @Column(name = "taille_designation")
    private String tailleDesignation;
    @Column(name = "couleur_designation")
    private String couleurDesignation;
    @Column(name = "poids_net")
    private Double poidsNet;
    @Column(name = "poids_brut")
    private Double poidsBrut;
    private String choix;
    private String tailles;
    private String code;
    @Column(name = "code_couleur")
    private String codeCouleur;
    @Column(name = "quantite_designation")
    private String quantiteDesignation;
}
