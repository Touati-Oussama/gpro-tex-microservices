package com.gpro.consulting.produit.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TailleValue {
    Long id;
    Long produitId;
    String designation;
    Integer ordre;
    String code;

    public TailleValue(Long id, String designation, Integer ordre, String code) {
        this.id = id;
        this.designation = designation;
        this.ordre = ordre;
        this.code = code;
    }


}
