package com.gpro.consulting.ordre.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Calendar;
import java.util.List;

@Entity
@Table(name = "gp_ficheeclatement")
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
    @JoinColumn(name = "gp_of_id")
    private OrdreFabrication ordreFabrication;

    @Id
    @GeneratedValue(generator = "FICHE_ECLATEMENT_ID_GENERATOR", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "FICHE_ECLATEMENT_SEQ", sequenceName = "FICHE_ECLATEMENT_SEQ", allocationSize = 1)
    private Long id;
    @Column(name = "date_lancement")
    private Calendar dateLancement;
    private String observations;
    @Column(name = "nombre_paquet")
    private Long nombrePaquet;
    @Column(name = "quantite_eclate")
    private Long quantiteEclate;
    @Column(name = "code_conception")
    private String codeConception;
    @Column(name = "client_abriviation")
    private String clientAbreviation;
    @Column(name = "produit_id")
    private Long produitId;
}
