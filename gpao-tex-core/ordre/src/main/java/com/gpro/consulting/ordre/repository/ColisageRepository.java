package com.gpro.consulting.ordre.repository;

import com.gpro.consulting.ordre.model.Colis;
import io.micrometer.common.KeyValues;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ColisageRepository extends JpaRepository<Colis, Long> {

}
