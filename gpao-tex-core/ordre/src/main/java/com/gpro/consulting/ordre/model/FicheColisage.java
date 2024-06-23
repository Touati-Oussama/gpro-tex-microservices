package com.gpro.consulting.ordre.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Calendar;
import java.util.List;

@Entity
@Table(name = "gp_Fiche_colisage")
@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FicheColisage extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "of_id")
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
    private Long nombreColis;
    private Long quantiteColis;
    private String numeroOf;
    private Long quantiteTotale;
    private Long produitId;
    private Long clientId;
    private String clientAbreviation;
    private String clientReference;
    private String couleur;
    private String produitDesignationInfo1;
    private String numeroInterne;
    private Calendar dateDe;
    private Calendar dateA;
}
