/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { BaseService } from '../base-service';
import { ApiConfiguration } from '../api-configuration';
import { StrictHttpResponse } from '../strict-http-response';

import { Couleur } from '../models/couleur';
import { CouleurValue } from '../models/couleur-value';
import { createCouleur } from '../fn/couleur-controller/create-couleur';
import { CreateCouleur$Params } from '../fn/couleur-controller/create-couleur';
import { deleteCouleur } from '../fn/couleur-controller/delete-couleur';
import { DeleteCouleur$Params } from '../fn/couleur-controller/delete-couleur';
import { findAll6 } from '../fn/couleur-controller/find-all-6';
import { FindAll6$Params } from '../fn/couleur-controller/find-all-6';
import { findCouleurById } from '../fn/couleur-controller/find-couleur-by-id';
import { FindCouleurById$Params } from '../fn/couleur-controller/find-couleur-by-id';

@Injectable({ providedIn: 'root' })
export class CouleurControllerService extends BaseService {
  constructor(config: ApiConfiguration, http: HttpClient) {
    super(config, http);
  }

  /** Path part for operation `createCouleur()` */
  static readonly CreateCouleurPath = '/api/produit/couleur/creerCouleur';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `createCouleur()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  createCouleur$Response(params: CreateCouleur$Params, context?: HttpContext): Observable<StrictHttpResponse<Couleur>> {
    return createCouleur(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `createCouleur$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  createCouleur(params: CreateCouleur$Params, context?: HttpContext): Observable<Couleur> {
    return this.createCouleur$Response(params, context).pipe(
      map((r: StrictHttpResponse<Couleur>): Couleur => r.body)
    );
  }

  /** Path part for operation `findCouleurById()` */
  static readonly FindCouleurByIdPath = '/api/produit/couleur/find/by/{id}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `findCouleurById()` instead.
   *
   * This method doesn't expect any request body.
   */
  findCouleurById$Response(params: FindCouleurById$Params, context?: HttpContext): Observable<StrictHttpResponse<CouleurValue>> {
    return findCouleurById(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `findCouleurById$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  findCouleurById(params: FindCouleurById$Params, context?: HttpContext): Observable<CouleurValue> {
    return this.findCouleurById$Response(params, context).pipe(
      map((r: StrictHttpResponse<CouleurValue>): CouleurValue => r.body)
    );
  }

  /** Path part for operation `findAll6()` */
  static readonly FindAll6Path = '/api/produit/couleur/find/all';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `findAll6()` instead.
   *
   * This method doesn't expect any request body.
   */
  findAll6$Response(params?: FindAll6$Params, context?: HttpContext): Observable<StrictHttpResponse<Array<CouleurValue>>> {
    return findAll6(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `findAll6$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  findAll6(params?: FindAll6$Params, context?: HttpContext): Observable<Array<CouleurValue>> {
    return this.findAll6$Response(params, context).pipe(
      map((r: StrictHttpResponse<Array<CouleurValue>>): Array<CouleurValue> => r.body)
    );
  }

  /** Path part for operation `deleteCouleur()` */
  static readonly DeleteCouleurPath = '/api/produit/couleur/delete/{id}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `deleteCouleur()` instead.
   *
   * This method doesn't expect any request body.
   */
  deleteCouleur$Response(params: DeleteCouleur$Params, context?: HttpContext): Observable<StrictHttpResponse<void>> {
    return deleteCouleur(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `deleteCouleur$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  deleteCouleur(params: DeleteCouleur$Params, context?: HttpContext): Observable<void> {
    return this.deleteCouleur$Response(params, context).pipe(
      map((r: StrictHttpResponse<void>): void => r.body)
    );
  }

}
