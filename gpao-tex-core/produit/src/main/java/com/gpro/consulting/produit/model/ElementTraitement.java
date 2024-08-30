package com.gpro.consulting.produit.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Table(name = "eb_element_traitement")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ElementTraitement extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "eb_produit_id")
    private Produit produit;

    @Id
    @GeneratedValue(generator = "EB_ELEMENT_TRAITEMENT_ID_GENERATOR_SEQ", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "EB_ELEMENT_TRAITEMENT_SEQ", sequenceName = "EB_ELEMENT_TRAITEMENT_SEQ", allocationSize = 1)
    private Long id;
    private String dimension;
    private String observation;
    @Column(name = "id_machine")
    private Long machineId;
    private String code;
    private String nature;
    private Double mesure;
    private Double tolerancePlus;
    private Double toleranceMoins;
}
