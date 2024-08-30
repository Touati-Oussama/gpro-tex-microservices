package com.gpro.consulting.partieprenante.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "pi_partieint")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PartieInteresse extends BaseEntity {

    @OneToMany(mappedBy = "partieInteresse", cascade = CascadeType.REMOVE)
    private List<Document> documents;

    @OneToMany(mappedBy = "partieInteresse", cascade = CascadeType.REMOVE)
    private List<Representant> representants;

    @Id
    @GeneratedValue(generator = "PARTIE_INT_ID_GENERATOR", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "PARTIE_INT_SEQ", sequenceName = "PARTIE_INT_SEQ", allocationSize = 1)
    private Long id;
    @Column(name = "pi_com_site_id")
    private Long siteId;
    @Column(name = "ref")
    private String reference;
    @Column(name = "matr_fiscal")
    private String matrFiscal;
    private String abreviation;
    @Column(name = "adresse")
    private String adresseLiv;
    @Column(name = "modalite_paiement")
    private String modalitePaiement;
}
