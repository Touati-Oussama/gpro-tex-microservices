package com.gpro.consulting.partieprenante.service;

import com.gpro.consulting.partieprenante.dto.DocumentPiValue;
import com.gpro.consulting.partieprenante.mapper.DocumentMapper;
import com.gpro.consulting.partieprenante.repository.DocumentRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DocumentService {

    private final DocumentRepository repository;
    private final DocumentMapper docMapper;

    public String createDoc(DocumentPiValue request) {
        var doc = docMapper.toDocument(request);
        return repository.save(doc).getId().toString();
    }


    public DocumentPiValue findById(Long id) {
        return docMapper.toDocumentValue(repository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.format("No pi found with the provided ID: %s", id))));

    }

    public void delete(Long id) {
        this.repository.deleteById(id);
    }

    public List<DocumentPiValue> findAll() {
        return this.repository.findAll()
                .stream()
                .map(docMapper::toDocumentValue)
                .collect(Collectors.toList());
    }
}
