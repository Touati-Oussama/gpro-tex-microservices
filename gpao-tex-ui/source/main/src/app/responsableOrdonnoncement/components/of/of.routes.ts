import {Route} from "@angular/router";
import {Page404Component} from "app/authentication/page404/page404.component";
import {AllOfComponent} from "./all-of/all-of.component";
import {AddOfComponent} from "./add-of/add-of.component";
import {EditOfComponent} from "./edit-of/edit-of.component";

export const OF_ROUTE: Route[] = [

  {
    path: "all-Of",
    component: AllOfComponent,
  },
  {
    path: "add-Of",
    component: AddOfComponent
  },

  {
    path: "edit-Of",
    component: EditOfComponent
  },

  {
    path: "**",
    component: Page404Component
  },
];
