package com.gpro.consulting.produit.repository;


import com.gpro.consulting.produit.model.Produit;
import com.gpro.consulting.produit.model.Theme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ThemeRepository extends JpaRepository<Theme, Long> {
    @Query(value = "SELECT t FROM Theme t " +
            "LEFT JOIN t.produit p " +
            "WHERE ( UPPER(t.designation) LIKE UPPER(:designation) OR :designation IS NULL) " +
            "AND (p = :produit OR :produit IS NULL) " +
            "AND (t.spl = :spl OR :spl IS NULL) " +
            "ORDER BY t.id DESC")
    List<Theme> rechercheThemeMultiCritere(
            @Param("designation") String designation,
            @Param("produit") Produit produit,
            @Param("spl") String spl);
}
