package com.gpro.consulting.ordre.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "gp_details_colisage")
@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DetailsColisage extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "ficheColisage_id")
    private FicheColisage ficheColisage;

    @Id
    @GeneratedValue(generator = "DETAILS_COLIS_ID_GENERATOR", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "DETAILS_COLIS_SEQ", sequenceName = "DETAILS_COLIS_SEQ", allocationSize = 1)
    private Long id;
    private Long couleurId;
    private Long tailleId;
    private Long quantiteRestante;
    private Long quantite;
    private Long pcb;
    private String tailleDesignation;
    private String couleurDesignation;
    private Double poidsNet;
    private Double poidsBrut;
    private String choix;
    private String tailles;
    private String code;
    private String codeCouleur;
    private String quantiteDesignation;
}
