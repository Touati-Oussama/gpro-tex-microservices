import { Route } from "@angular/router";
import { Page404Component } from "app/authentication/page404/page404.component";
import { AllSiteComponent } from "./all-site/all-site.component";
import { AddSiteComponent } from "./add-site/add-site.component";
import { EditSiteComponent } from "./edit-site/edit-site.component";


export const SITE_ROUTE: Route[] = [
      {
        path: "all-site",
        component: AllSiteComponent,
      },
      {
        path: "add-site",
        component: AddSiteComponent,
      },
      {
        path: "edit-site",
        component: EditSiteComponent,
      },
    
      { 
        path: "**", 
        component: Page404Component 
      },
];