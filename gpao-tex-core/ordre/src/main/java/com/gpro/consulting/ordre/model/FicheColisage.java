package com.gpro.consulting.ordre.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Calendar;
import java.util.List;

@Entity
@Table(name = "gp_fichecolisage")
@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FicheColisage extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "gp_of_id")
    private OrdreFabrication ordre;

    @OneToMany(mappedBy = "ficheColisage", cascade = CascadeType.REMOVE)
    private List<Colis> colis;

    @OneToMany(mappedBy = "ficheColisage", cascade = CascadeType.REMOVE)
    private List<DetailsColisage> detailsColisages;

    @Id
    @GeneratedValue(generator = "FICHE_COLISAGE_ID_GENERATOR", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "FICHE_COLISAGE_SEQ", sequenceName = "FICHE_COLISAGE_SEQ", allocationSize = 1)
    private Long id;
    private String observations;
    @Column(name = "nombre_colis")
    private Long nombreColis;
    @Column(name = "quantite_colis")
    private Long quantiteColis;
    @Column(name = "numero_of")
    private String numeroOf;
    @Column(name = "quantite_totale")
    private Long quantiteTotale;
    @Column(name = "produit_id")
    private Long produitId;
    @Column(name = "client_id")
    private Long clientId;
    @Column(name = "client_abreviation")
    private String clientAbreviation;
    @Column(name = "client_reference")
    private String clientReference;
    private String couleur;
    @Column(name = "produit_designation_info_1")
    private String produitDesignationInfo1;
    @Column(name = "numero_interne")
    private String numeroInterne;
    @Column(name = "date_de")
    private Calendar dateDe;
    @Column(name = "date")
    private Calendar dateA;
}
