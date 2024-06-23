import {Route} from '@angular/router';
import {MainLayoutComponent} from './layout/app-layout/main-layout/main-layout.component';
import {Page404Component} from './authentication/page404/page404.component';
import {Role} from '@core';
import {authGuard} from '@core/guard/auth-guard.service';

export const APP_ROUTE: Route[] = [
  {
    path: '',
    component: MainLayoutComponent,
    canActivate: [authGuard],
    children: [
      {
        path: 'admin',
        canActivate: [authGuard],
        data: {
          role: Role.Admin,
        },
        loadChildren: () =>
          import('./admin/admin.routes').then((m) => m.ADMIN_ROUTE),
      },

      {
        path: 'commercial',
        canActivate: [authGuard],
        data: {
          roles: [Role.Admin, Role.Responsable_commercial]
        },
        loadChildren: () =>
          import('./responsableCommerciale/commerciale.routes').then((m) => m.RESPONSABLE_COMMERCIALE_ROUTE),
      },

      {
        path: 'productionRes',
        canActivate: [authGuard],
        data: {
          roles: [Role.Admin, Role.Responsable_production]
        },
        loadChildren: () =>
          import('./responsableProduction/productionRes.routes').then((m) => m.RESPONSABLE_PRODUCTION_ROUTE),
      },

      {
        path: 'ordRes',
        canActivate: [authGuard],
        data: {
          roles: [Role.Admin, Role.Responsable_ordonnancement]
        },
        loadChildren: () =>
          import('./responsableOrdonnoncement/ordonnoncement.routes').then((m) => m.RESPONSABLE_ORD_ROUTE),
      },
    ],
  },
  {path: '**', component: Page404Component},
];
