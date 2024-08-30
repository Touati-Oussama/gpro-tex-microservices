package com.gpro.consulting.produit.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Calendar;

@Entity
@Table(name = "eb_ligne_produit")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LigneProduit extends BaseEntity {

    @Id
    @GeneratedValue(generator = "LIGNE_PRODUIT_ID_GENERATOR", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "LIGNE_PRODUIT_SEQ", sequenceName = "LIGNE_PRODUIT_SEQ", allocationSize = 1)
    private Long id;
    private String designation;
    @Column(name = "id_fournisseur")
    private Long fournisseur;
    private Calendar finDe;
    private Calendar finA;
}
