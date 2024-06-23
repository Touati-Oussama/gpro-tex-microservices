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
    @JoinColumn(name = "ficheEclatement_id")
    private FicheEclatement ficheEclatement;

    @ManyToOne
    @JoinColumn(name = "of_id")
    private OrdreFabrication ordre;

    @Id
    @GeneratedValue(generator = "GP_CHAINE_ID_GENERATOR", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "GP_CHAINE_SEQ", sequenceName = "GP_CHAINE_SEQ", allocationSize = 1)
    private Long id;
    private String designation;
    private Long siteId;
    private Calendar dateLibre;
    private boolean planning;
    private String designationClient;
    private Boolean production;
    private Boolean developpement;
    private String posteQualite1;
    private String defaut1;
    private Long nbDefaut1;
}

