package com.gpro.consulting.ordre.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "gp_paquet")
@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Paquet extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "of_id")
    private OrdreFabrication ordreFabrication;

    @ManyToOne
    @JoinColumn(name = "ficheEclatement_id")
    private FicheEclatement ficheEclatement;

    @Id
    @GeneratedValue(generator = "FICHE_ECLATEMENT_ID_GENERATOR", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "FICHE_ECLATEMENT_SEQ", sequenceName = "FICHE_ECLATEMENT_SEQ", allocationSize = 1)
    private Long id;
    private Long num;
    private Boolean productionHeure;
    private Long siteId;
    private Long couleurId;
    private Long tailleId;
    private Long quantite;
    private String numMatelas;
    private String numRouleaux;
    private Boolean entreeDos;
    private Boolean sortieDos;
    private Boolean entreeDevant;
    private Boolean sortieDevant;
    private Boolean sortieAssemblage;
    private Boolean entreeAssemblage;
    private Boolean entreeFinition;
    private Boolean entreePreparation;
    private Boolean sortiePreparation;
    private Boolean engagement;
    private String retrait;
}
