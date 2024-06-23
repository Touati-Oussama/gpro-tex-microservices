import {Route} from "@angular/router";
import {Page404Component} from "app/authentication/page404/page404.component";
import {AllGoShippementComponent} from "./all-go-shippement/all-go-shippement.component";


export const GO_SHIPPEMENT_ROUTE: Route[] = [
  {
    path: "all-go-ship-prod",
    component: AllGoShippementComponent
  },
  {
    path: "**",
    component: Page404Component
  },
];
