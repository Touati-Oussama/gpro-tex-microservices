package com.gpro.consulting.produit.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "theme")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Theme extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "produit_id")
    private Produit produit;

    @Id
    @GeneratedValue(generator = "THEME_ID_GENERATOR", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "THEME_ID_SEQ", sequenceName = "THEME_ID_SEQ", allocationSize = 1)
    private Long id;
    private String designation;
    private String spl;
}
