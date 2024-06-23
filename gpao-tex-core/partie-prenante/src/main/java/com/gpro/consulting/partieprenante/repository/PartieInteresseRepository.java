package com.gpro.consulting.partieprenante.repository;

import com.gpro.consulting.partieprenante.model.PartieInteresse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PartieInteresseRepository extends JpaRepository<PartieInteresse, Long> {
    @Query("SELECT p.abreviation, p.reference " + "FROM PartieInteresse p WHERE p.id = :id")
    PartieInteresse findAbbriviationAndReferenceById(@Param("id") Long id);

    @Query("SELECT p FROM PartieInteresse p " +
            "WHERE (:siteId IS NULL OR p.siteId = :siteId) " +
            "AND (:reference IS NULL OR p.reference LIKE %:reference%) " +
            "AND (:matrFiscal IS NULL OR p.matrFiscal LIKE %:matrFiscal%) " +
            "AND (:abreviation IS NULL OR p.abreviation LIKE %:abreviation%) " +
            "AND (:adresseLiv IS NULL OR p.adresseLiv LIKE %:adresseLiv%) " +
            "AND (:modalitePaiement IS NULL OR p.modalitePaiement LIKE %:modalitePaiement%)")
    List<PartieInteresse> findByCriteria(Long siteId, String reference, String matrFiscal,
                                                String abreviation, String adresseLiv, String modalitePaiement);
}
