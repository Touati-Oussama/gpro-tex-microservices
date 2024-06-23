package com.gpro.consulting.production.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Calendar;
import java.util.List;

@Entity
@Table(name = "gp_production_heure")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ProductionHeure extends BaseEntity {

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "productionHeure", cascade = CascadeType.REMOVE)
    private List<ProductionHeureDetails> productionHeureDetails;

    @Id
    @GeneratedValue(generator = "PRODUCTIONHEURE_ID_GENERATOR", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "PRODUCTIONHEURE_SEQ", sequenceName = "PRODUCTIONHEURE_SEQ", allocationSize = 1)
    private Long id;
    private Calendar date;
    private Long quantite;
    private String observation;
    private Long elementPlanningId;
    private Long ofId;
    private Long chaineId;
    private Long partieInterreseId;
    private Long produitId;
    private String periode;
}
