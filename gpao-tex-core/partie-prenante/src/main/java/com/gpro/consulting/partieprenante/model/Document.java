package com.gpro.consulting.partieprenante.model;

import com.gpro.consulting.partieprenante.dto.DocumentPiValue;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "pi_document")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Document extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "partieInteresse_id")
    private PartieInteresse partieInteresse;

    @Id
    @GeneratedValue(generator = "DOCUMENT_ID_GENERATOR", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "DOCUMENT_TRAITEMENT_SEQ", sequenceName = "DOCUMENT_TRAITEMENT_SEQ", allocationSize = 1)
    private Long id;
    private String path;
    private String uidDocument;

    public Document(DocumentPiValue documentValue) {
    }
}
