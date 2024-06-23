package com.gpro.consulting.partieprenante.mapper;

import com.gpro.consulting.partieprenante.dto.RepresentantValue;
import com.gpro.consulting.partieprenante.model.PartieInteresse;
import com.gpro.consulting.partieprenante.model.Representant;
import org.springframework.stereotype.Component;

@Component
public class RepresentantMapper {
    public Representant toRepresentant(RepresentantValue request) {
        if (request == null) {
            return null;
        }
        return Representant.builder()
                .id(request.getId())
                .nom(request.getNom())
                .fonction(request.getFonction())
                .email(request.getEmail())
                .telephone(request.getTelephone())
                .fax(request.getFax())
                .partieInteresse(request.getPartieInteresseId() != null ?
                        PartieInteresse.builder().id(request.getPartieInteresseId()).build() : null)
                .build();
    }

    public RepresentantValue toRepresentantValue(Representant representant) {
        if (representant == null) {
            return null;
        }
        return new RepresentantValue(
                representant.getId(),
                representant.getNom(),
                representant.getFonction(),
                representant.getEmail(),
                representant.getTelephone(),
                representant.getFax(),
                representant.getPartieInteresse() != null ? representant.getPartieInteresse().getId() : null
        );
    }
}
