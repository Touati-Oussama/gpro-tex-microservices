package com.gpro.consulting.produit.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ThemeValue {
    Long id;
    Long produitId;
    String designation;
    String spl;


    public ThemeValue(Long id, String designation, String spl) {
        this.id = id;
        this.designation = designation;
        this.spl = spl;
    }



}
