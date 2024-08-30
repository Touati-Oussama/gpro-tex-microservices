package com.gpro.consulting.produit.mapper;

import com.gpro.consulting.produit.dto.ThemeValue;
import com.gpro.consulting.produit.model.Produit;
import com.gpro.consulting.produit.model.Theme;
import org.springframework.stereotype.Component;

@Component
public class ThemeMapper {

    public Theme toTheme(ThemeValue themeValue) {
        if (themeValue == null) {
            return null;
        }

        return Theme.builder()
                .id(themeValue.getId())
                //.produit(Produit.builder().id(themeValue.getProduitId()).build())
                .designation(themeValue.getDesignation())
                .spl(themeValue.getSpl())
                .build();
    }

    public ThemeValue fromTheme(Theme theme) {
        if (theme == null) {
            return null;
        }

        return new ThemeValue(
                theme.getId(),
                //theme.getProduit().getId(),
                theme.getDesignation(),
                theme.getSpl()
        );
    }
}

