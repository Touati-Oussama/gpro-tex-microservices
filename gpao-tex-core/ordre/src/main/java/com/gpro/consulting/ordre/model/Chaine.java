package com.gpro.consulting.ordre.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Calendar;

@Entity
@Table(name = "gp_chaine")
@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Chaine extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "fiche_eclatement_id")
    private FicheEclatement ficheEclatement;

    @ManyToOne
    @JoinColumn(name = "of_id")
    private OrdreFabrication ordre;

    @Id
    @GeneratedValue(generator = "GP_CHAINE_ID_GENERATOR", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "GP_CHAINE_SEQ", sequenceName = "GP_CHAINE_SEQ", allocationSize = 1)
    private Long id;
    private String designation;
    @Column(name = "id_site")
    private Long siteId;
    @Column(name="date_libre")
    private Calendar dateLibre;
    private boolean planning;
    @Column(name="designation_client")
    private String designationClient;
    private Boolean production;
    private Boolean developpement;
    @Column(name="poste_qualite1")
    private String posteQualite1;
    private String defaut1;
    @Column(name="nb_defaut1")
    private Long nbDefaut1;
}

