package com.gpro.consulting.ordre.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Calendar;
import java.util.Set;

@Entity
@Table(name = "gp_ordrefabrication")
@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrdreFabrication extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "chaine_id")
    private Chaine chaine;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ordre", cascade = CascadeType.REMOVE)
    private Set<DetailOf> detailOfs;

    @Id
    @GeneratedValue(generator = "GP_ORDREFABRICATION_ID_GENERATOR", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "GP_ORDREFABRICATION_SEQ", sequenceName = "GP_ORDREFABRICATION_SEQ", allocationSize = 1)
    private Long id;
    private Long quantite;
    @Column(name = "produit_id")
    private Long produitId;

    @Column(name = "pi_pi_id")
    private Long partieInterresId;
    private String type;
    @Column(name = "date_debut")
    private Calendar dateDebut;
    @Column(name = "date_fin")
    private Calendar dateFin;
    private String priorite;
    private String status;
    @Column(name = "informations_stock")
    private String informationsStock;
    @Column(name = "qt_coupe")
    private Long qtCoupe;
    @Column(name = "qt_engagement")
    private Long qtEngagement;
    @Column(name = "qt_sortie")
    private Long qtSortie;
    @Column(name = "qt_finition")
    private Long qtFinition;
    @Column(name = "qt_colisage")
    private Long qtColisage;
    @Column(name = "qt_expedition")
    private Long qtExpedition;

    private Long qtePriseProd;
    private Long qteRecueProd;
    private Long qtePriseCoupe;
    private Long qteRecuCoupe;
    private Long qtePreteCoupe;
    private Long qteEntreeAssemblage;
    private Long qteSortieAssemblage;
    private Long qteEntreeFinition;
    private Long qteEntreePreparation;
    private Long qteSortiePreparation;
    private Boolean modifierQtSortieManuel;
    private Boolean split;
    private Boolean majQteOfAvecImportation;
    private String statusPlanning;
    private String inspection;
    private String implantation;
    private Long quantiteDetailOrdres;
    private Long nombreColis;
}
