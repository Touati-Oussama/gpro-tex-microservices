package com.gpro.consulting.ordre.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Calendar;

@Entity
@Table(name = "gp_colis")
@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Colis extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "ficheColisage_id")
    private FicheColisage ficheColisage;

    @ManyToOne
    @JoinColumn(name = "of_id")
    private OrdreFabrication ordre;

    @Id
    @GeneratedValue(generator = "COLIS_ID_GENERATOR", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "COLIS_SEQ", sequenceName = "COLIS_SEQ", allocationSize = 1)
    private Long id;
    private Long couleurId;
    private Long tailleId;
    private Long siteId;
    private Long produitId;
    private String tailles;
    private Long quantite;
    private Double poidsNet;
    private Double poidsBrut;
    private String palette;
    private Calendar dateSortie;
    private Calendar dateLancementDe;
    private Calendar dateLancementA;
}
