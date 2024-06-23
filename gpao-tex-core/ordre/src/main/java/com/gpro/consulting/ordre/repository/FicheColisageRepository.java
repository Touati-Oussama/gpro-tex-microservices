package com.gpro.consulting.ordre.repository;

import com.gpro.consulting.ordre.model.FicheColisage;
import io.micrometer.common.KeyValues;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FicheColisageRepository extends JpaRepository<FicheColisage, Long> {
}
