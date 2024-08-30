package com.gpro.consulting.ordre.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "gp_capacitesemaine")
@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CapaciteSemaine extends BaseEntity {

    @Id
    @GeneratedValue(generator = "CAPACITE_SEMAINE_ID_GENERATOR", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "CAPACITE_SEMAINE_SEQ", sequenceName = "CAPACITE_SEMAINE_SEQ", allocationSize = 1)
    private Long id;
    private Long semaine;
    private Long semainesDe;
    private Long semainesA;
    @Column(name="capacite_totale")
    private Double capaciteTotale;
    @Column(name="capacite_previsionnelle")
    private Double capacitePrevisionnelle;
    @Column(name="nombre_heure")
    private Double nombreHeure;
    @Column(name="taux_absence")
    private Double tauxAbsence;
    private Long fin1;
    @Column(name="atelier_id")
    private Long atelierId;
    private Long annee;
}

