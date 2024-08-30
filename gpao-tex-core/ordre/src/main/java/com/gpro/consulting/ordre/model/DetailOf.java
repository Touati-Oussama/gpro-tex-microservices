package com.gpro.consulting.ordre.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Calendar;

@Entity
@Table(name = "gp_detailsof")
@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DetailOf extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "gp_of_id")
    private OrdreFabrication ordre;

    @Id
    @GeneratedValue(generator = "GP_DETAILSOF_ID_GENERATOR", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "GP_DETAILSOF_SEQ", sequenceName = "GP_DETAILSOF_SEQ", allocationSize = 1)
    private Long id;
    private Long pcb;
    private Long quantite;
    @Column(name = "eb_taille_id")
    private Long tailleId;
    @Column(name = "eb_couleur_id")
    private Long couleurId;
    @Column(name = "type_ordre")
    private String typeOrdre;
    @Column(name = "lieu_livraison")
    private String lieuLivraison;
    private String dimension;
    private String ue;
    private String code;
    @Column(name = "code_couleur")
    private String codeCouleur;
    @Column(name = "poids_net")
    private Double poidsNet;
    @Column(name = "poids_brut")
    private Double poidsBrut;
    @Column(name = "gte_recu_coupe")
    private Long qteRecuCoupe;
    @Column(name = "gte_prete_coupe")
    private Long qtePreteCoupe;
    @Column(name = "gte_prise_prod")
    private Long qtePriseProd;
    @Column(name = "gte_prise_coupe")
    private Long qtePriseCoupe;
    @Column(name = "gte_recu_prod")
    private Long qteRecueProd;
    @Column(name = "gte_produite")
    private Long qteProduite;
}



