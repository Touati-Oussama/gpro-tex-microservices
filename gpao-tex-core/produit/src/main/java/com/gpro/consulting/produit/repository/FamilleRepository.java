package com.gpro.consulting.produit.repository;

import com.gpro.consulting.produit.model.FamilleProduit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FamilleRepository extends JpaRepository<FamilleProduit, Long> {
}
