package com.gpro.consulting.produit.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "eb_go_shippement")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProduitGoShippement extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "site_id")
    private Site site;

    @ManyToOne
    @JoinColumn(name = "eb_produit_id")
    private Produit produit;

    @Id
    @GeneratedValue(generator = "GO_SHIPPEMENT_ID_GENERATOR", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "GO_SHIPPEMENT_SEQ", sequenceName = "GO_SHIPPEMENT_SEQ", allocationSize = 1)
    private Long id;
    private String saison;
    private String goShippement;
}
