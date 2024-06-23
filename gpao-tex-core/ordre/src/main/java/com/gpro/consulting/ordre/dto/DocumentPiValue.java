package com.gpro.consulting.ordre.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocumentPiValue {
    Long id;
    Long partieInteresseId;
    String path;
    String uidDocument;
}
