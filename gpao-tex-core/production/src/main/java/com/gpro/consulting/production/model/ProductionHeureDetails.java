package com.gpro.consulting.production.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Calendar;

@Entity
@Table(name = "gp_production_heure_details")
@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductionHeureDetails extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "productionHeure_id")
    private ProductionHeure productionHeure;

    @Id
    @GeneratedValue(generator = "PRODUCTION_HEURE_DETAILS_ID_GENERATOR", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "PRODUCTION_HEURE_DETAILS_SEQ", sequenceName = "PRODUCTION_HEURE_DETAILS_SEQ", allocationSize = 1)
    private Long id;
    private Long detailsId;
    private Double qteFinie;
    private Double qteNonEmballe;
    private Double qteRetouche;
    private Double qteDeuxiemeChoix;
    private Long nbreColis;
    private Calendar date;
    private Long numPaquet;
    private Long paquetId;
    private Long colisId;
    private Boolean complement;
    private Long quantite;
    private String operation;
    private String observations;
    private Long tailleId;
    private Long couleurId;
    private Long ordrePaquet;
    private String numMatelasPaquet;
    private String nature;
}
