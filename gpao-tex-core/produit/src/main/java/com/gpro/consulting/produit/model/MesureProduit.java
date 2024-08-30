package com.gpro.consulting.produit.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "eb_mesure_produit")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MesureProduit extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "eb_produit_id")
    private Produit produit;

    @ManyToOne
    @JoinColumn(name = "id_taille")
    private Taille taille;

    @Id
    @GeneratedValue(generator = "MESUREPRODUIT_ID_GENERATOR", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "MESUREPRODUIT_SEQ", sequenceName = "MESUREPRODUIT_SEQ", allocationSize = 1)
    private Long id;
    private String code;
    private Double mesure;
    private Double tolerancePlus;
    private Double toleranceMoins;
}
