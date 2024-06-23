import {Route} from "@angular/router";
import {Page404Component} from "app/authentication/page404/page404.component";
import {AllCouleurComponent} from "./all-couleur/all-couleur.component";
import {AddCouleurComponent} from "./add-couleur/add-couleur.component";
import {EditCouleurComponent} from "./edit-couleur/edit-couleur.component";

export const COULEUR_PRODUIT_ROUTE: Route[] = [

  {
    path: "all-couleur",
    component: AllCouleurComponent,
  },
  {
    path: "add-couleur",
    component: AddCouleurComponent
  },
  {
    path: "edit-couleur",
    component: EditCouleurComponent
  },
  {
    path: "**",
    component: Page404Component
  },
];
