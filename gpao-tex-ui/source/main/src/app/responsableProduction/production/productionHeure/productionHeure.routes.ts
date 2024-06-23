import {Route} from "@angular/router";
import {Page404Component} from "app/authentication/page404/page404.component";
import {AddProductionHeureComponent} from "./add-production-heure/add-production-heure.component";
import {AllProductionHeureComponent} from "./all-production-heure/all-production-heure.component";
import {EditProductionHeureComponent} from "./edit-production-heure/edit-production-heure.component";

export const PRODUCTION_HEURE_ROUTE: Route[] = [
  {
    path: "add-prod-heure",
    component: AddProductionHeureComponent
  },
  {
    path: "all-prod-heure",
    component: AllProductionHeureComponent
  },
  {
    path: "edit-prod-heure",
    component: EditProductionHeureComponent
  },
  {
    path: "**",
    component: Page404Component
  },
];
