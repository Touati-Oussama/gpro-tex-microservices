package com.gpro.consulting.production.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Calendar;

@Entity
@Table(name = "gp_production_jour")
@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductionJour extends BaseEntity {

    @Id
    @GeneratedValue(generator = "PRODUCTIONJOUR_ID_GENERATOR", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "PRODUCTIONJOUR_SEQ", sequenceName = "PRODUCTIONJOUR_SEQ", allocationSize = 1)
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
