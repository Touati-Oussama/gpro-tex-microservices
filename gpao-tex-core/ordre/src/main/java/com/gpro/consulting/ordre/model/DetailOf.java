package com.gpro.consulting.ordre.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Calendar;

@Entity
@Table(name = "gp_details_of")
@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DetailOf extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "of_id")
    private OrdreFabrication ordre;

    @Id
    @GeneratedValue(generator = "GP_DETAILSOF_ID_GENERATOR", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "GP_DETAILSOF_SEQ", sequenceName = "GP_DETAILSOF_SEQ", allocationSize = 1)
    private Long id;
    private Long pcb;
    private Long quantite;
    private Long tailleId;
    private Long couleurId;
    private String typeOrdre;
    private String lieuLivraison;
    private String dimension;
    private String ue;
    private String code;
    private String codeCouleur;
    private Double poidsNet;
    private Double poidsBrut;
    private Long qteRecuCoupe;
    private Long qtePreteCoupe;
    private Long qtePriseProd;
    private Long qtePriseCoupe;
    private Long qteRecueProd;
    private Long qteProduite;
}



