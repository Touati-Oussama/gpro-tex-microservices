package com.gpro.consulting.produit.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "eb_couleur")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Couleur extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "produit_id")
    private Produit produit;

    @Id
    @GeneratedValue(generator = "COULEUR_ID_GENERATOR", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "COULEUR_ID_SEQ", sequenceName = "COULEUR_ID_SEQ", allocationSize = 1)
    private Long id;
    private String designation;
    private String codeCouleur;
}
