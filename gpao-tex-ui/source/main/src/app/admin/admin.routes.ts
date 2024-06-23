import {Route} from '@angular/router';
import {authGuard} from "@core/guard/auth-guard.service";
import {Role} from "@core";

export const ADMIN_ROUTE: Route[] = [
  {
    path: 'dashboard',
    canActivate: [authGuard],
    data: {
      role: Role.Admin,
    },
    loadChildren: () =>
      import('./dashboard/dashboard.routes').then((m) => m.ADMIN_DASHBOARD_ROUTE),
  },
  {
    path: 'site',
    loadChildren: () =>
      import('./site/site.routes').then((m) => m.SITE_ROUTE),
  },
  {
    path: 'commerciale',
    loadChildren: () =>
      import('../responsableCommerciale/commerciale.routes').then((m) => m.RESPONSABLE_COMMERCIALE_ROUTE),
  },
  {
    path: 'ordonnoncement',
    loadChildren: () =>
      import('../responsableOrdonnoncement/ordonnoncement.routes').then((m) => m.RESPONSABLE_ORD_ROUTE),
  },
  {
    path: 'production',
    loadChildren: () =>
      import('../responsableProduction/productionRes.routes').then((m) => m.RESPONSABLE_PRODUCTION_ROUTE),
  },
];

