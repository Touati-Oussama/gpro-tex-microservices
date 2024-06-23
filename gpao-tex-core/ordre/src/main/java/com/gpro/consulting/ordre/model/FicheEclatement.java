package com.gpro.consulting.ordre.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Calendar;
import java.util.List;

@Entity
@Table(name = "gp_fiche_eclatement")
@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FicheEclatement extends BaseEntity {

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ficheEclatement", cascade = CascadeType.REMOVE)
    private List<Paquet> paquets;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ficheEclatement", cascade = CascadeType.REMOVE)
    private List<Chaine> chaines;

    @ManyToOne
    @JoinColumn(name = "of_id")
    private OrdreFabrication ordreFabrication;

    @Id
    @GeneratedValue(generator = "FICHE_ECLATEMENT_ID_GENERATOR", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "FICHE_ECLATEMENT_SEQ", sequenceName = "FICHE_ECLATEMENT_SEQ", allocationSize = 1)
    private Long id;
    private Calendar dateLancement;
    private String observations;
    private Long nombrePaquet;
    private Long quantiteEclate;
    private String codeConception;
    private String clientAbreviation;
    private Long produitId;
}
