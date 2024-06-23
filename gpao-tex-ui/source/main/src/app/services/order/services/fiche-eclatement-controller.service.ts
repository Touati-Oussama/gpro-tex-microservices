/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { BaseService } from '../base-service';
import { ApiConfiguration } from '../api-configuration';
import { StrictHttpResponse } from '../strict-http-response';

import { creerFicheEclat } from '../fn/fiche-eclatement-controller/creer-fiche-eclat';
import { CreerFicheEclat$Params } from '../fn/fiche-eclatement-controller/creer-fiche-eclat';
import { deleteFicheEclat } from '../fn/fiche-eclatement-controller/delete-fiche-eclat';
import { DeleteFicheEclat$Params } from '../fn/fiche-eclatement-controller/delete-fiche-eclat';
import { FicheEclatement } from '../models/fiche-eclatement';
import { FicheEclatementValue } from '../models/fiche-eclatement-value';
import { findAll2 } from '../fn/fiche-eclatement-controller/find-all-2';
import { FindAll2$Params } from '../fn/fiche-eclatement-controller/find-all-2';
import { findFicheEclatById } from '../fn/fiche-eclatement-controller/find-fiche-eclat-by-id';
import { FindFicheEclatById$Params } from '../fn/fiche-eclatement-controller/find-fiche-eclat-by-id';

@Injectable({ providedIn: 'root' })
export class FicheEclatementControllerService extends BaseService {
  constructor(config: ApiConfiguration, http: HttpClient) {
    super(config, http);
  }

  /** Path part for operation `creerFicheEclat()` */
  static readonly CreerFicheEclatPath = '/api/order/ficheEclat/creerFicheEclat';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `creerFicheEclat()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  creerFicheEclat$Response(params: CreerFicheEclat$Params, context?: HttpContext): Observable<StrictHttpResponse<FicheEclatement>> {
    return creerFicheEclat(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `creerFicheEclat$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  creerFicheEclat(params: CreerFicheEclat$Params, context?: HttpContext): Observable<FicheEclatement> {
    return this.creerFicheEclat$Response(params, context).pipe(
      map((r: StrictHttpResponse<FicheEclatement>): FicheEclatement => r.body)
    );
  }

  /** Path part for operation `findFicheEclatById()` */
  static readonly FindFicheEclatByIdPath = '/api/order/ficheEclat/find/by/{id}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `findFicheEclatById()` instead.
   *
   * This method doesn't expect any request body.
   */
  findFicheEclatById$Response(params: FindFicheEclatById$Params, context?: HttpContext): Observable<StrictHttpResponse<FicheEclatementValue>> {
    return findFicheEclatById(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `findFicheEclatById$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  findFicheEclatById(params: FindFicheEclatById$Params, context?: HttpContext): Observable<FicheEclatementValue> {
    return this.findFicheEclatById$Response(params, context).pipe(
      map((r: StrictHttpResponse<FicheEclatementValue>): FicheEclatementValue => r.body)
    );
  }

  /** Path part for operation `findAll2()` */
  static readonly FindAll2Path = '/api/order/ficheEclat/find/all';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `findAll2()` instead.
   *
   * This method doesn't expect any request body.
   */
  findAll2$Response(params?: FindAll2$Params, context?: HttpContext): Observable<StrictHttpResponse<Array<FicheEclatementValue>>> {
    return findAll2(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `findAll2$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  findAll2(params?: FindAll2$Params, context?: HttpContext): Observable<Array<FicheEclatementValue>> {
    return this.findAll2$Response(params, context).pipe(
      map((r: StrictHttpResponse<Array<FicheEclatementValue>>): Array<FicheEclatementValue> => r.body)
    );
  }

  /** Path part for operation `deleteFicheEclat()` */
  static readonly DeleteFicheEclatPath = '/api/order/ficheEclat/delete/{id}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `deleteFicheEclat()` instead.
   *
   * This method doesn't expect any request body.
   */
  deleteFicheEclat$Response(params: DeleteFicheEclat$Params, context?: HttpContext): Observable<StrictHttpResponse<void>> {
    return deleteFicheEclat(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `deleteFicheEclat$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  deleteFicheEclat(params: DeleteFicheEclat$Params, context?: HttpContext): Observable<void> {
    return this.deleteFicheEclat$Response(params, context).pipe(
      map((r: StrictHttpResponse<void>): void => r.body)
    );
  }

}
