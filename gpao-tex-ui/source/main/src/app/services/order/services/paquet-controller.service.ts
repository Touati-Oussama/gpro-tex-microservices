/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { BaseService } from '../base-service';
import { ApiConfiguration } from '../api-configuration';
import { StrictHttpResponse } from '../strict-http-response';

import { creerPaquet } from '../fn/paquet-controller/creer-paquet';
import { CreerPaquet$Params } from '../fn/paquet-controller/creer-paquet';
import { deletePaquet } from '../fn/paquet-controller/delete-paquet';
import { DeletePaquet$Params } from '../fn/paquet-controller/delete-paquet';
import { findAll } from '../fn/paquet-controller/find-all';
import { FindAll$Params } from '../fn/paquet-controller/find-all';
import { findPaquetById } from '../fn/paquet-controller/find-paquet-by-id';
import { FindPaquetById$Params } from '../fn/paquet-controller/find-paquet-by-id';
import { Paquet } from '../models/paquet';
import { PaquetValue } from '../models/paquet-value';

@Injectable({ providedIn: 'root' })
export class PaquetControllerService extends BaseService {
  constructor(config: ApiConfiguration, http: HttpClient) {
    super(config, http);
  }

  /** Path part for operation `creerPaquet()` */
  static readonly CreerPaquetPath = '/api/order/paquet/creerPaquet';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `creerPaquet()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  creerPaquet$Response(params: CreerPaquet$Params, context?: HttpContext): Observable<StrictHttpResponse<Paquet>> {
    return creerPaquet(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `creerPaquet$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  creerPaquet(params: CreerPaquet$Params, context?: HttpContext): Observable<Paquet> {
    return this.creerPaquet$Response(params, context).pipe(
      map((r: StrictHttpResponse<Paquet>): Paquet => r.body)
    );
  }

  /** Path part for operation `findPaquetById()` */
  static readonly FindPaquetByIdPath = '/api/order/paquet/find/by/{id}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `findPaquetById()` instead.
   *
   * This method doesn't expect any request body.
   */
  findPaquetById$Response(params: FindPaquetById$Params, context?: HttpContext): Observable<StrictHttpResponse<PaquetValue>> {
    return findPaquetById(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `findPaquetById$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  findPaquetById(params: FindPaquetById$Params, context?: HttpContext): Observable<PaquetValue> {
    return this.findPaquetById$Response(params, context).pipe(
      map((r: StrictHttpResponse<PaquetValue>): PaquetValue => r.body)
    );
  }

  /** Path part for operation `findAll()` */
  static readonly FindAllPath = '/api/order/paquet/find/all';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `findAll()` instead.
   *
   * This method doesn't expect any request body.
   */
  findAll$Response(params?: FindAll$Params, context?: HttpContext): Observable<StrictHttpResponse<Array<PaquetValue>>> {
    return findAll(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `findAll$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  findAll(params?: FindAll$Params, context?: HttpContext): Observable<Array<PaquetValue>> {
    return this.findAll$Response(params, context).pipe(
      map((r: StrictHttpResponse<Array<PaquetValue>>): Array<PaquetValue> => r.body)
    );
  }

  /** Path part for operation `deletePaquet()` */
  static readonly DeletePaquetPath = '/api/order/paquet/delete/{id}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `deletePaquet()` instead.
   *
   * This method doesn't expect any request body.
   */
  deletePaquet$Response(params: DeletePaquet$Params, context?: HttpContext): Observable<StrictHttpResponse<void>> {
    return deletePaquet(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `deletePaquet$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  deletePaquet(params: DeletePaquet$Params, context?: HttpContext): Observable<void> {
    return this.deletePaquet$Response(params, context).pipe(
      map((r: StrictHttpResponse<void>): void => r.body)
    );
  }

}
