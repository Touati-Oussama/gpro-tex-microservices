import {Route} from "@angular/router";
import {Page404Component} from "app/authentication/page404/page404.component";
import {AllCouleurComponent} from "../couleur/all-couleur/all-couleur.component";
import {AddCouleurComponent} from "../couleur/add-couleur/add-couleur.component";
import {EditCouleurComponent} from "../couleur/edit-couleur/edit-couleur.component";
import {AddTailleComponent} from "./add-taille/add-taille.component";
import {AllTailleComponent} from "./all-taille/all-taille.component";
import {EditTailleComponent} from "./edit-taille/edit-taille.component";

export const TAILLE_PRODUIT_ROUTE: Route[] = [


  {
    path: "add-taille",
    component: AddTailleComponent,
  },
  {
    path: "all-taille",
    component: AllTailleComponent
  },
  {
    path: "edit-taille",
    component: EditTailleComponent
  },
  {
    path: "**",
    component: Page404Component
  },
];
