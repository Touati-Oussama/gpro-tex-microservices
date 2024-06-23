package com.gpro.consulting.ordre.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Calendar;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FicheEclatementValue {
    Long id;
    List<PaquetValue> paquets;
    List<ChaineValue> chaines;
    Long ordreId;
    Calendar dateLancement;
    String observations;
    Long nombrePaquet;
    Long quantiteEclate;
    String codeConception;
    String clientAbreviation;
    Long produitId;
}
