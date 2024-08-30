package com.gpro.consulting.partieprenante.model;

import com.gpro.consulting.partieprenante.dto.RepresentantValue;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "pi_representant")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
public class Representant extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "pi_partieint_id")
    private PartieInteresse partieInteresse;
    @Id
    @GeneratedValue(generator = "REPRESENTENT_PARTIE_INTERESSE_ID_GENERATOR", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "REPRESENTENT_PARTIE_INTERESSE_ID_SEQ", sequenceName = "REPRESENTENT_PARTIE_INTERESSE_ID_SEQ", allocationSize = 1)
    private Long id;
    private String nom;
    private String fonction;
    private String email;
    @Column(name = "tel")
    private String telephone;
    private String fax;

    public Representant(RepresentantValue representantValue) {
    }
}
