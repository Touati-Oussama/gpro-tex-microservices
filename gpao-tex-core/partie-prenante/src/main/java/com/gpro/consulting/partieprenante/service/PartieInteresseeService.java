package com.gpro.consulting.partieprenante.service;

import com.gpro.consulting.partieprenante.dto.DocumentPiValue;
import com.gpro.consulting.partieprenante.dto.PartieInteresseValue;
import com.gpro.consulting.partieprenante.dto.RepresentantValue;
import com.gpro.consulting.partieprenante.mapper.PiMapper;
import com.gpro.consulting.partieprenante.model.Document;
import com.gpro.consulting.partieprenante.model.PartieInteresse;
import com.gpro.consulting.partieprenante.model.Representant;
import com.gpro.consulting.partieprenante.repository.PartieInteresseRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PartieInteresseeService {

    private final PartieInteresseRepository repository;
    private final PiMapper piMapper;

    public String createPi(PartieInteresseValue request) {
        var pi = piMapper.toPi(request);
        return repository.save(pi).getId().toString();
    }

    public String updatePi(PartieInteresseValue request) {

        Optional<PartieInteresse> existingPiOptional = repository.findById(request.getId());
        if (existingPiOptional.isPresent()) {
            PartieInteresse existingPi = existingPiOptional.get();
            existingPi.setReference(request.getReference() != null ? request.getReference() : existingPi.getReference());
            existingPi.setMatrFiscal(request.getMatrFiscal() != null ? request.getMatrFiscal() : existingPi.getMatrFiscal());
            updateDocuments(existingPi, request.getDocuments());
            updateRepresentants(existingPi, request.getRepresentants());
            PartieInteresse savedPi = repository.save(existingPi);
            return savedPi.getId().toString();
        } else {
            throw new EntityNotFoundException(String.format("PartieInteresse not found with ID: %s", request.getId()));
        }
    }

    private void updateDocuments(PartieInteresse piToUpdate, List<DocumentPiValue> documentValues) {
        if (documentValues == null) {
            return;
        }
        piToUpdate.getDocuments().clear();
        for (DocumentPiValue documentValue : documentValues) {
            Document document = new Document(documentValue);
            document.setPartieInteresse(piToUpdate);
            piToUpdate.getDocuments().add(document);
        }
    }

    private void updateRepresentants(PartieInteresse piToUpdate, List<RepresentantValue> representantValues) {
        if (representantValues == null) {
            return;
        }
        piToUpdate.getRepresentants().clear();
        for (RepresentantValue representantValue : representantValues) {
            Representant representant = new Representant(representantValue);
            representant.setPartieInteresse(piToUpdate);
            piToUpdate.getRepresentants().add(representant);
        }
    }

    public Optional<PartieInteresseValue> findById(Long id) {
        return repository.findById(id)
                .map(piMapper::fromPi);
    }

    public void delete(Long id) {
        this.repository.deleteById(id);
    }

    public List<PartieInteresseValue> findAll() {
        return this.repository.findAll()
                .stream()
                .map(this.piMapper::fromPi)
                .collect(Collectors.toList());
    }

    public PartieInteresseValue getAbreviationClient(Long id) {
        return piMapper.fromPi(repository.findAbbriviationAndReferenceById(id));
    }

    public List<PartieInteresseValue> findByCriteria(Long siteId, String reference, String matrFiscal,
                                                     String abreviation, String adresseLiv, String modalitePaiement) {
        List<PartieInteresse> result = repository.findByCriteria(siteId, reference, matrFiscal, abreviation, adresseLiv, modalitePaiement);
        return piMapper.fromPiList(result);
    }
}
