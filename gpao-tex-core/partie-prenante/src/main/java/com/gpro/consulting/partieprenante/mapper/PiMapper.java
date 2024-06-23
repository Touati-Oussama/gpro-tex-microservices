package com.gpro.consulting.partieprenante.mapper;

import com.gpro.consulting.partieprenante.dto.DocumentPiValue;
import com.gpro.consulting.partieprenante.dto.PartieInteresseValue;
import com.gpro.consulting.partieprenante.dto.RepresentantValue;
import com.gpro.consulting.partieprenante.model.Document;
import com.gpro.consulting.partieprenante.model.PartieInteresse;
import com.gpro.consulting.partieprenante.model.Representant;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PiMapper {
    private final DocumentMapper documentMapper;
    private final RepresentantMapper representantMapper;

    public PartieInteresse toPi(PartieInteresseValue request) {
        if (request == null) {
            return null;
        }

        List<Document> documents = request.getDocuments() != null ? request.getDocuments().stream()
                .map(documentMapper::toDocument)
                .collect(Collectors.toList()) : null;

        List<Representant> representants = request.getRepresentants() != null ? request.getRepresentants().stream()
                .map(representantMapper::toRepresentant)
                .collect(Collectors.toList()) : null;

        return PartieInteresse.builder()
                .id(request.getId())
                .siteId(request.getSiteId())
                .reference(request.getReference())
                .matrFiscal(request.getMatrFiscal())
                .abreviation(request.getAbreviation())
                .adresseLiv(request.getAdresseLiv())
                .modalitePaiement(request.getModalitePaiement())
                .documents(documents)
                .representants(representants)
                .build();
    }

    public PartieInteresseValue fromPi(PartieInteresse partieInteresse) {
        if (partieInteresse == null) {
            return null;
        }

        List<DocumentPiValue> documentPiValues = partieInteresse.getDocuments() != null ? partieInteresse.getDocuments().stream()
                .map(documentMapper::toDocumentValue)
                .collect(Collectors.toList()) : null;

        List<RepresentantValue> representantValues = partieInteresse.getRepresentants() != null ? partieInteresse.getRepresentants().stream()
                .map(representantMapper::toRepresentantValue)
                .collect(Collectors.toList()) : null;

        return new PartieInteresseValue(
                partieInteresse.getId(),
                partieInteresse.getSiteId(),
                partieInteresse.getReference(),
                partieInteresse.getMatrFiscal(),
                partieInteresse.getAbreviation(),
                partieInteresse.getAdresseLiv(),
                partieInteresse.getModalitePaiement(),
                documentPiValues,
                representantValues,
                partieInteresse.getCreatorIdentifier(),
                partieInteresse.getLatestUpdaterId()
        );
    }

    public List<PartieInteresseValue> fromPiList(List<PartieInteresse> partieInteresses) {
        if (partieInteresses == null) {
            return null;
        }
        return partieInteresses.stream()
                .map(this::fromPi)
                .collect(Collectors.toList());
    }
}
