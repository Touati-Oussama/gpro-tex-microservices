import {Route} from "@angular/router";
import {Page404Component} from "app/authentication/page404/page404.component";
import {
  AddProductionHeureDetailsComponent
} from "./add-production-heure-details/add-production-heure-details.component";
import {
  AllProductionHeureDetailsComponent
} from "./all-production-heure-details/all-production-heure-details.component";
import {
  EditProductionHeureDetailsComponent
} from "./edit-production-heure-details/edit-production-heure-details.component";

export const PRODUCTION_HEURE_DETAILS_ROUTE: Route[] = [
  {
    path: "add-prod-heure-details",
    component: AddProductionHeureDetailsComponent
  },
  {
    path: "all-prod-heure-details",
    component: AllProductionHeureDetailsComponent
  },
  {
    path: "edit-prod-heure-details",
    component: EditProductionHeureDetailsComponent
  },
  {
    path: "**",
    component: Page404Component
  },
];
