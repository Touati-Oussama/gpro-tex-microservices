package com.gpro.consulting.produit.repository;

import com.gpro.consulting.produit.model.Site;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SiteRepository extends JpaRepository<Site, Long> {

    @Query("SELECT s FROM Site s WHERE s.sitePrincipal = true")
    List<Site> findAllBySitePrincipal();
}
