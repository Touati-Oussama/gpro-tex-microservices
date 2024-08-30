package com.gpro.consulting.produit.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "pi_com_site")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Site extends BaseEntity {

    @Id
    @GeneratedValue(generator = "SITE_ID_GENERATOR", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "SITE_SEQ", sequenceName = "SITE_SEQ", allocationSize = 1)
    private Long id;
    private String nom;
    private String designation;
    private String abriviation;
    private boolean sitePrincipal;
    private Long effidapSiteId;
    private Boolean production;
    private Long debut;
    private Long fin1;
    private Long fin2;
    private Long fin3;
    private Long fin4;
    private Long fin5;
}
