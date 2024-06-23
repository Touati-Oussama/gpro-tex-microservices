/* tslint:disable */
/* eslint-disable */
import { NgModule, ModuleWithProviders, SkipSelf, Optional } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ApiConfiguration, ApiConfigurationParams } from './api-configuration';

import { PaquetControllerService } from './services/paquet-controller.service';
import { OrdreFabricationControllerService } from './services/ordre-fabrication-controller.service';
import { FicheEclatementControllerService } from './services/fiche-eclatement-controller.service';
import { FicheColisageControllerService } from './services/fiche-colisage-controller.service';
import { DetailsOfControllerService } from './services/details-of-controller.service';
import { ColisControllerService } from './services/colis-controller.service';
import { ChaineControllerService } from './services/chaine-controller.service';
import { CapaciteSemaineControllerService } from './services/capacite-semaine-controller.service';

/**
 * Module that provides all services and configuration.
 */
@NgModule({
  imports: [],
  exports: [],
  declarations: [],
  providers: [
    PaquetControllerService,
    OrdreFabricationControllerService,
    FicheEclatementControllerService,
    FicheColisageControllerService,
    DetailsOfControllerService,
    ColisControllerService,
    ChaineControllerService,
    CapaciteSemaineControllerService,
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
