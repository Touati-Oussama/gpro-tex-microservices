package com.gpro.consulting.partieprenante.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "pi_pi")
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
    private Long siteId;
    private String reference;
    private String matrFiscal;
    private String abreviation;
    private String adresseLiv;
    private String modalitePaiement;
}
