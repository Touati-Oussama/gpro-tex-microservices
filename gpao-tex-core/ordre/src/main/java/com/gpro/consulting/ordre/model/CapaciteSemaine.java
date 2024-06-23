package com.gpro.consulting.ordre.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "gp_capacite_semaine")
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
    private Double capaciteTotale;
    private Double capacitePrevisionnelle;
    private Double nombreHeure;
    private Double tauxAbsence;
    private Long fin1;
    private Long atelierId;
    private Long annee;
}

