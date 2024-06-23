import {Route} from "@angular/router";
import {Page404Component} from "app/authentication/page404/page404.component";
import {AddLigneProduitComponent} from "./add-ligne-produit/add-ligne-produit.component";
import {AllLigneProduitComponent} from "./all-ligne-produit/all-ligne-produit.component";
import {EditLigneProduitComponent} from "./edit-ligne-produit/edit-ligne-produit.component";

export const LIGNE_PRODUIT_ROUTE: Route[] = [
  {
    path: "add-ligne-prod",
    component: AddLigneProduitComponent
  },
  {
    path: "all-ligne-prod",
    component: AllLigneProduitComponent
  },
  {
    path: "edit-ligne-prod",
    component: EditLigneProduitComponent
  },
  {
    path: "**",
    component: Page404Component
  },
];
