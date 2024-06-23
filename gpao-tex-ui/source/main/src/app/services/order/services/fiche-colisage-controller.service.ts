/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { BaseService } from '../base-service';
import { ApiConfiguration } from '../api-configuration';
import { StrictHttpResponse } from '../strict-http-response';

import { creerFiche } from '../fn/fiche-colisage-controller/creer-fiche';
import { CreerFiche$Params } from '../fn/fiche-colisage-controller/creer-fiche';
import { deleteFicheColis } from '../fn/fiche-colisage-controller/delete-fiche-colis';
import { DeleteFicheColis$Params } from '../fn/fiche-colisage-controller/delete-fiche-colis';
import { FicheColisage } from '../models/fiche-colisage';
import { FicheColisageValue } from '../models/fiche-colisage-value';
import { findAll3 } from '../fn/fiche-colisage-controller/find-all-3';
import { FindAll3$Params } from '../fn/fiche-colisage-controller/find-all-3';
import { findFicheColisById } from '../fn/fiche-colisage-controller/find-fiche-colis-by-id';
import { FindFicheColisById$Params } from '../fn/fiche-colisage-controller/find-fiche-colis-by-id';

@Injectable({ providedIn: 'root' })
export class FicheColisageControllerService extends BaseService {
  constructor(config: ApiConfiguration, http: HttpClient) {
    super(config, http);
  }

  /** Path part for operation `creerFiche()` */
  static readonly CreerFichePath = '/api/order/ficheColi/creerFiche';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `creerFiche()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  creerFiche$Response(params: CreerFiche$Params, context?: HttpContext): Observable<StrictHttpResponse<FicheColisage>> {
    return creerFiche(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `creerFiche$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  creerFiche(params: CreerFiche$Params, context?: HttpContext): Observable<FicheColisage> {
    return this.creerFiche$Response(params, context).pipe(
      map((r: StrictHttpResponse<FicheColisage>): FicheColisage => r.body)
    );
  }

  /** Path part for operation `findFicheColisById()` */
  static readonly FindFicheColisByIdPath = '/api/order/ficheColi/find/by/{id}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `findFicheColisById()` instead.
   *
   * This method doesn't expect any request body.
   */
  findFicheColisById$Response(params: FindFicheColisById$Params, context?: HttpContext): Observable<StrictHttpResponse<FicheColisageValue>> {
    return findFicheColisById(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `findFicheColisById$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  findFicheColisById(params: FindFicheColisById$Params, context?: HttpContext): Observable<FicheColisageValue> {
    return this.findFicheColisById$Response(params, context).pipe(
      map((r: StrictHttpResponse<FicheColisageValue>): FicheColisageValue => r.body)
    );
  }

  /** Path part for operation `findAll3()` */
  static readonly FindAll3Path = '/api/order/ficheColi/find/all';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `findAll3()` instead.
   *
   * This method doesn't expect any request body.
   */
  findAll3$Response(params?: FindAll3$Params, context?: HttpContext): Observable<StrictHttpResponse<Array<FicheColisageValue>>> {
    return findAll3(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `findAll3$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  findAll3(params?: FindAll3$Params, context?: HttpContext): Observable<Array<FicheColisageValue>> {
    return this.findAll3$Response(params, context).pipe(
      map((r: StrictHttpResponse<Array<FicheColisageValue>>): Array<FicheColisageValue> => r.body)
    );
  }

  /** Path part for operation `deleteFicheColis()` */
  static readonly DeleteFicheColisPath = '/api/order/ficheColi/delete/{id}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `deleteFicheColis()` instead.
   *
   * This method doesn't expect any request body.
   */
  deleteFicheColis$Response(params: DeleteFicheColis$Params, context?: HttpContext): Observable<StrictHttpResponse<void>> {
    return deleteFicheColis(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `deleteFicheColis$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  deleteFicheColis(params: DeleteFicheColis$Params, context?: HttpContext): Observable<void> {
    return this.deleteFicheColis$Response(params, context).pipe(
      map((r: StrictHttpResponse<void>): void => r.body)
    );
  }

}
