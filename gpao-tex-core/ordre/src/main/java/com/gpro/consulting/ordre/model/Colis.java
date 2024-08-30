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
    @JoinColumn(name = "gp_fiche_id")
    private FicheColisage ficheColisage;

    @ManyToOne
    @JoinColumn(name = "ordre")
    private OrdreFabrication ordre;

    @Id
    @GeneratedValue(generator = "COLIS_ID_GENERATOR", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "COLIS_SEQ", sequenceName = "COLIS_SEQ", allocationSize = 1)
    private Long id;
    @Column(name="eb_couleur_id")
    private Long couleurId;
    @Column(name="eb_taille_id")
    private Long tailleId;
    @Column(name="id_site")
    private Long siteId;
    @Column(name="produit_id")
    private Long produitId;
    private String tailles;
    private Long quantite;
    @Column(name="poids_net")
    private Double poidsNet;
    @Column(name="poids_brut")
    private Double poidsBrut;
    private String palette;
    @Column(name="date_sortie")
    private Calendar dateSortie;
    @Column(name="date_lancement_de")
    private Calendar dateLancementDe;
    @Column(name="date_lancementa")
    private Calendar dateLancementA;
}
