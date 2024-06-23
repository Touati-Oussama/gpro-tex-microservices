import {Route} from "@angular/router";
import {Page404Component} from "app/authentication/page404/page404.component";


export const PRODUCTION_ROUTE: Route[] = [
  {
    path: 'productionHeure',
    loadChildren: () =>
      import('./productionHeure/productionHeure.routes').then((m) => m.PRODUCTION_HEURE_ROUTE),
  },

  {
    path: 'productionHeureDetails',
    loadChildren: () =>
      import('./productionHeureDetails/productionHeureDetails.routes').then((m) => m.PRODUCTION_HEURE_DETAILS_ROUTE),
  },

  {
    path: 'productionJour',
    loadChildren: () =>
      import('./productionJour/productionJour.routes').then((m) => m.PRODUCTION_JOUR_ROUTE),
  },

  {
    path: "**",
    component: Page404Component
  },
];
