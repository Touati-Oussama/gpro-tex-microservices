package com.gpro.consulting.produit.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "eb_familleprod")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FamilleProduit extends BaseEntity {

    @Id
    @GeneratedValue(generator = "FAMILLE_PRODUIT_ID_GENERATOR", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "FAMILLE_PRODUIT_SEQ", sequenceName = "FAMILLE_PRODUIT_SEQ", allocationSize = 1)
    private Long id;
    private String designation;
    private boolean achat;
    private boolean vente;
}
