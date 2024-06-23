import {Route} from "@angular/router";
import {Page404Component} from "app/authentication/page404/page404.component";
import {AddFamilleProduitComponent} from "./add-famille-produit/add-famille-produit.component";
import {AllFamilleProduitComponent} from "./all-famille-produit/all-famille-produit.component";
import {EditFamilleProduitComponent} from "./edit-famille-produit/edit-famille-produit.component";

export const FAMILLE_PRODUIT_ROUTE: Route[] = [
  {
    path: "add-famille-prod",
    component: AddFamilleProduitComponent
  },
  {
    path: "all-famille-prod",
    component: AllFamilleProduitComponent
  },
  {
    path: "edit-famille-prod",
    component: EditFamilleProduitComponent
  },
  {
    path: "**",
    component: Page404Component
  },
];
