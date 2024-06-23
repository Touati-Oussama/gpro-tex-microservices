package com.gpro.consulting.partieprenante.mapper;

import com.gpro.consulting.partieprenante.dto.DocumentPiValue;
import com.gpro.consulting.partieprenante.model.Document;
import com.gpro.consulting.partieprenante.model.PartieInteresse;
import org.springframework.stereotype.Component;

@Component
public class DocumentMapper {

    public Document toDocument(DocumentPiValue request) {
        if (request == null) {
            return null;
        }
        return Document.builder()
                .id(request.getId())
                .path(request.getPath())
                .uidDocument(request.getUidDocument())
                .partieInteresse(request.getPartieInteresseId() != null ?
                        PartieInteresse.builder().id(request.getPartieInteresseId()).build() : null)
                .build();
    }

    public DocumentPiValue toDocumentValue(Document document) {
        if (document == null) {
            return null;
        }
        return new DocumentPiValue(
                document.getId(),
                document.getPartieInteresse() != null ? document.getPartieInteresse().getId() : null,
                document.getPath(),
                document.getUidDocument()

        );
    }
}
