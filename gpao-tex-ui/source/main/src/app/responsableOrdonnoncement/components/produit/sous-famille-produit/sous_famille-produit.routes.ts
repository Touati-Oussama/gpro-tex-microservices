import {Route} from "@angular/router";
import {Page404Component} from "app/authentication/page404/page404.component";
import {AddSousFamilleProduitComponent} from "./add-sous-famille-produit/add-sous-famille-produit.component";
import {AllSousFamilleProduitComponent} from "./all-sous-famille-produit/all-sous-famille-produit.component";
import {EditSousFamilleProduitComponent} from "./edit-sous-famille-produit/edit-sous-famille-produit.component";

export const SOUS_FAMILLE_PRODUIT_ROUTE: Route[] = [
  {
    path: "add-sf-prod",
    component: AddSousFamilleProduitComponent
  },
  {
    path: "all-sf-prod",
    component: AllSousFamilleProduitComponent
  },
  {
    path: "edit-sf-prod",
    component: EditSousFamilleProduitComponent
  },
  {
    path: "**",
    component: Page404Component
  },
];
