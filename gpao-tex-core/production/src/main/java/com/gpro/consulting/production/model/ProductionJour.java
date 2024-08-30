package com.gpro.consulting.production.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Calendar;

@Entity
@Table(name = "gp_productionjour")
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
    @Column(name = "elementplanning_id")
    private Long elementPlanningId;
    @Column(name = "of")
    private Long ofId;
    @Column(name = "chaine")
    private Long chaineId;
    @Column(name = "pi_pi_id")
    private Long partieInterreseId;
    @Column(name = "produit_id")
    private Long produitId;
    private String periode;
}
