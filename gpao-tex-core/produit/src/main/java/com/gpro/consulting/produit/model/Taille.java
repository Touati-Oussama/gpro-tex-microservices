package com.gpro.consulting.produit.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "eb_taille")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Taille extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "produit_id")
    private Produit produit;

    @Id
    @GeneratedValue(generator = "TAILLE_ID_GENERATOR", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "TAILLE_ID_SEQ", sequenceName = "TAILLE_ID_SEQ", allocationSize = 1)
    private Long id;
    private String designation;
    private Integer ordre;
    private String code;
}
