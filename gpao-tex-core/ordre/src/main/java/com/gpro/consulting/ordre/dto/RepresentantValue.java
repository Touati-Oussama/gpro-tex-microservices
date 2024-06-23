package com.gpro.consulting.ordre.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RepresentantValue {
    Long id;
    String nom;
    String fonction;
    String email;
    String telephone;
    String fax;
    Long partieInteresseId;
}
