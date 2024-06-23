import {Route} from "@angular/router";
import {Page404Component} from "app/authentication/page404/page404.component";
import {AddProductionJourComponent} from "./add-production-jour/add-production-jour.component";
import {AllProductionJourComponent} from "./all-production-jour/all-production-jour.component";
import {EditProductionJourComponent} from "./edit-production-jour/edit-production-jour.component";

export const PRODUCTION_JOUR_ROUTE: Route[] = [
  {
    path: "add-prod-jour",
    component: AddProductionJourComponent
  },
  {
    path: "all-prod-jour",
    component: AllProductionJourComponent
  },
  {
    path: "edit-prod-jour",
    component: EditProductionJourComponent
  },
  {
    path: "**",
    component: Page404Component
  },
];
