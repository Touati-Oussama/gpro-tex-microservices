import {Route} from "@angular/router";
import {Page404Component} from "app/authentication/page404/page404.component";
import {COULEUR_PRODUIT_ROUTE} from "./couleur/couleur.routes";
import {TAILLE_PRODUIT_ROUTE} from "./taille/taille.routes";
import {THEME_PRODUIT_ROUTE} from "./theme/theme.routes";
import {GO_SHIPPEMENT_ROUTE} from "./go-shippement/go-shippement-produit.routes";
import {DOCUMENT_ROUTE} from "./document/document-produit.routes";
import {ELEMENT_TRAITEMENT_ROUTE} from "./element-traitement/element-traitement-produit.routes";

export const PARAM_PRODUIT_ROUTE: Route[] = [

  {
    path: 'famille-produit',
    loadChildren: () =>
      import('./famille-produit/famille-produit.routes').then((m) => m.FAMILLE_PRODUIT_ROUTE),
  },
  {
    path: 'mesure-produit',
    loadChildren: () =>
      import('./mesure-produit/mesure-produit.routes').then((m) => m.MESURE_PRODUIT_ROUTE),
  },
  {
    path: 'ligne-produit',
    loadChildren: () =>
      import('./ligne-produit/ligne-produit.routes').then((m) => m.LIGNE_PRODUIT_ROUTE),
  },
  {
    path: 'sf-produit',
    loadChildren: () =>
      import('./sous-famille-produit/sous_famille-produit.routes').then((m) => m.SOUS_FAMILLE_PRODUIT_ROUTE),
  },
  {
    path: 'couleur-produit',
    loadChildren: () =>
      import('./couleur/couleur.routes').then((m) => COULEUR_PRODUIT_ROUTE),
  },
  {
    path: 'taille-produit',
    loadChildren: () =>
      import('./taille/taille.routes').then((m) => TAILLE_PRODUIT_ROUTE),
  },
  {
    path: 'theme-produit',
    loadChildren: () =>
      import('./theme/theme.routes').then((m) => THEME_PRODUIT_ROUTE),
  },
  {
    path: 'go-shippement-produit',
    loadChildren: () =>
      import('./go-shippement/go-shippement-produit.routes').then((m) => GO_SHIPPEMENT_ROUTE),
  },
  {
    path: 'document',
    loadChildren: () =>
      import('./document/document-produit.routes').then((m) => DOCUMENT_ROUTE),
  },
  {
    path: 'element',
    loadChildren: () =>
      import('./element-traitement/element-traitement-produit.routes').then((m) => ELEMENT_TRAITEMENT_ROUTE),
  },
  {
    path: "**",
    component: Page404Component
  },
];
