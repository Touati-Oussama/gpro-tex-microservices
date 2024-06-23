import {Route} from "@angular/router";
import {AllPiComponent} from "./components/pi/all-pi/all-pi.component";
import {AddPiComponent} from "./components/pi/add-pi/add-pi.component";
import {EditPiComponent} from "./components/pi/edit-pi/edit-pi.component";
import {Page404Component} from "app/authentication/page404/page404.component";
import {AllProduitComponent} from "./components/produit/all-produit/all-produit.component";
import {AddProduitComponent} from "./components/produit/add-produit/add-produit.component";
import {EditProduitComponent} from "./components/produit/edit-produit/edit-produit.component";
import {CommercialedashboardComponent} from "./layout/commercialedashboard/commercialedashboard.component";


export const RESPONSABLE_COMMERCIALE_ROUTE: Route[] = [
  {
    path: "commercial-dashboard",
    component: CommercialedashboardComponent
  },
  {
    path: "all-pi",
    component: AllPiComponent,
  },
  {
    path: "add-pi",
    component: AddPiComponent,
  },
  {
    path: "edit-pi",
    component: EditPiComponent,
  },
  {
    path: "all-produit",
    component: AllProduitComponent,
  },
  {
    path: "add-prduit",
    component: AddProduitComponent,
  },
  {
    path: "edit-produit",
    component: EditProduitComponent,
  },
  {
    path: "**",
    component: Page404Component
  },
];
