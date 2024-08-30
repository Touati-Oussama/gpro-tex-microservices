package com.gpro.consulting.produit.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "eb_sousfamilleprod")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SousFamilleProduit extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "eb_familleprod_id")
    private FamilleProduit familleProduit;

    @Id
    @GeneratedValue(generator = "SOUS_FAM_PRODUIT_ID_GENERATOR", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "SOUS_FAM_PRODUIT_ID_GENERATOR", sequenceName = "SOUS_FAM_PRODUIT_ID_GENERATOR", allocationSize = 1)
    private Long id;
    private String designation;
}
