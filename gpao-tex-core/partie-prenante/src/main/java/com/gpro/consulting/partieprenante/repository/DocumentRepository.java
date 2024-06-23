package com.gpro.consulting.partieprenante.repository;

import com.gpro.consulting.partieprenante.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document, Long> {
}
