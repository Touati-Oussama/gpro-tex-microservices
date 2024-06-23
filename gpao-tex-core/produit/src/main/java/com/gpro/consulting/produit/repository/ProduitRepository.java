package com.gpro.consulting.produit.repository;

import com.gpro.consulting.produit.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProduitRepository extends JpaRepository<Produit, Long> {

    @Query("SELECT p.id, p.reference, p.designation, p.codeConception, p.partieInteresseId, p.sousFamilleProduit.id, p.sousFamilleProduit.designation FROM Produit p")
    List<Produit> listeProduitOptimise();
    Produit findByReference(@Param("reference") String reference);

    List<Produit> findByCodeConceptionOrderByIdDesc(String codeConception);
}
