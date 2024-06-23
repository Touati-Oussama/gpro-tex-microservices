import {Route} from "@angular/router";
import {Page404Component} from "app/authentication/page404/page404.component";
import {AllChaineComponent} from "./chaine/all-chaine/all-chaine.component";
import {EditChaineComponent} from "./chaine/edit-chaine/edit-chaine.component";
import {AddChaineComponent} from "./chaine/add-chaine/add-chaine.component";
import {
  AllPilotageEfficienceComponent
} from "./pilotagee-effecience/all-pilotage-efficience/all-pilotage-efficience.component";
import {
  EditPilotageEfficienceComponent
} from "./pilotagee-effecience/edit-pilotage-efficience/edit-pilotage-efficience.component";
import {
  AddPilotageEfficienceComponent
} from "./pilotagee-effecience/add-pilotage-efficience/add-pilotage-efficience.component";
import {ProductiondashboardComponent} from "./layout/productiondashboard/productiondashboard.component";


export const RESPONSABLE_PRODUCTION_ROUTE: Route[] = [
  {
    path: "ordonnoncement-dashboard",
    component: ProductiondashboardComponent
  },
  {
    path: 'productionHeure',
    loadChildren: () =>
      import('./production/production.routes').then((m) => m.PRODUCTION_ROUTE),
  },

  {
    path: "all-chaine",
    component: AllChaineComponent,
  },
  {
    path: "edit-chaine",
    component: EditChaineComponent,
  },
  {
    path: "add-chaine",
    component: AddChaineComponent,
  },
  {
    path: "all-pilotage",
    component: AllPilotageEfficienceComponent,
  },
  {
    path: "edit-pilotage",
    component: EditPilotageEfficienceComponent,
  },
  {
    path: "add-pilotage",
    component: AddPilotageEfficienceComponent,
  },
  {
    path: 'production',
    loadChildren: () =>
      import('./production/production.routes').then((m) => m.PRODUCTION_ROUTE),
  },
  {
    path: "**",
    component: Page404Component
  },
];
