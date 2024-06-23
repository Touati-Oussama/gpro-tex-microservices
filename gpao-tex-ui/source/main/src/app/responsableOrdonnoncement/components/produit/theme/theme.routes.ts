import {Route} from "@angular/router";
import {Page404Component} from "app/authentication/page404/page404.component";
import {AddTailleComponent} from "../taille/add-taille/add-taille.component";
import {AllTailleComponent} from "../taille/all-taille/all-taille.component";
import {EditTailleComponent} from "../taille/edit-taille/edit-taille.component";

export const THEME_PRODUIT_ROUTE: Route[] = [


  {
    path: "add-theme",
    component: AddTailleComponent,
  },
  {
    path: "all-theme",
    component: AllTailleComponent
  },
  {
    path: "edit-theme",
    component: EditTailleComponent
  },
  {
    path: "**",
    component: Page404Component
  },
];
