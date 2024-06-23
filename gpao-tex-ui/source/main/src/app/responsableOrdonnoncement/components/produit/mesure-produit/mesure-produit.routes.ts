import {Route} from "@angular/router";
import {Page404Component} from "app/authentication/page404/page404.component";
import {AddMesureProduitComponent} from "./add-mesure-produit/add-mesure-produit.component";
import {AllMesureProduitComponent} from "./all-mesure-produit/all-mesure-produit.component";
import {EditMesureProduitComponent} from "./edit-mesure-produit/edit-mesure-produit.component";

export const MESURE_PRODUIT_ROUTE: Route[] = [
  {
    path: "add-mesure-prod",
    component: AddMesureProduitComponent
  },
  {
    path: "all-mesure-prod",
    component: AllMesureProduitComponent
  },
  {
    path: "edit-mesure-prod",
    component: EditMesureProduitComponent
  },
  {
    path: "**",
    component: Page404Component
  },
];
