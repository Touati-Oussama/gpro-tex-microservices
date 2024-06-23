import {Route} from "@angular/router";
import {Page404Component} from "app/authentication/page404/page404.component";
import {AllChaineComponent} from "../responsableProduction/chaine/all-chaine/all-chaine.component";
import {OrdonnoncementdashboardComponent} from "./layout/ordonnoncementdashboard/ordonnoncementdashboard.component";

export const RESPONSABLE_ORD_ROUTE: Route[] = [

  {
    path: "ordonnoncement-dashboard",
    component: OrdonnoncementdashboardComponent
  },

  {
    path: 'of',
    loadChildren: () =>
      import('./components/of/of.routes').then((m) => m.OF_ROUTE),
  },
  {
    path: 'param-produit',
    loadChildren: () =>
      import('./components/produit/parametres-produit.routes').then((m) => m.PARAM_PRODUIT_ROUTE),
  },
  {
    path: "**",
    component: Page404Component
  },
];
