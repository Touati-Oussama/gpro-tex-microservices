package com.gpro.consulting.produit.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "eb_pilotage_efficience")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PilotageEfficience extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "site_id")
    private Site site;

    @ManyToOne
    @JoinColumn(name = "eb_produit_id")
    private Produit produit;

    @Id
    @GeneratedValue(generator = "PILOTAGE_EFFICIENCE_ID_GENERATOR", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "PILOTAGE_EFFICIENCE_SEQ", sequenceName = "PILOTAGE_EFFICIENCE_SEQ", allocationSize = 1)
    private Long id;
    private Double efficienceJour1;
    private Double efficienceJour2;
    private Double efficienceJour3;
    private Double efficienceJour4;
    private Double efficienceJour5;
    private Double efficienceJour6;
    private Double efficienceJour7;
}
