/* tslint:disable */
/* eslint-disable */
import { NgModule, ModuleWithProviders, SkipSelf, Optional } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ApiConfiguration, ApiConfigurationParams } from './api-configuration';

import { ThemeControllerService } from './services/theme-controller.service';
import { TailleControllerService } from './services/taille-controller.service';
import { SiteControllerService } from './services/site-controller.service';
import { PilotageEfficienceControllerService } from './services/pilotage-efficience-controller.service';
import { ProduitControllerService } from './services/produit-controller.service';
import { LigneProduitControllerService } from './services/ligne-produit-controller.service';
import { CouleurControllerService } from './services/couleur-controller.service';

/**
 * Module that provides all services and configuration.
 */
@NgModule({
  imports: [],
  exports: [],
  declarations: [],
  providers: [
    ThemeControllerService,
    TailleControllerService,
    SiteControllerService,
    PilotageEfficienceControllerService,
    ProduitControllerService,
    LigneProduitControllerService,
    CouleurControllerService,
    ApiConfiguration
  ],
})
export class ApiModule {
  static forRoot(params: ApiConfigurationParams): ModuleWithProviders<ApiModule> {
    return {
      ngModule: ApiModule,
      providers: [
        {
          provide: ApiConfiguration,
          useValue: params
        }
      ]
    }
  }

  constructor( 
    @Optional() @SkipSelf() parentModule: ApiModule,
    @Optional() http: HttpClient
  ) {
    if (parentModule) {
      throw new Error('ApiModule is already loaded. Import in your base AppModule only.');
    }
    if (!http) {
      throw new Error('You need to import the HttpClientModule in your AppModule! \n' +
      'See also https://github.com/angular/angular/issues/20575');
    }
  }
}
