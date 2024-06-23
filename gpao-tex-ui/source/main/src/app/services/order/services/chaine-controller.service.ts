/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { BaseService } from '../base-service';
import { ApiConfiguration } from '../api-configuration';
import { StrictHttpResponse } from '../strict-http-response';

import { Chaine } from '../models/chaine';
import { ChaineValue } from '../models/chaine-value';
import { createChaine } from '../fn/chaine-controller/create-chaine';
import { CreateChaine$Params } from '../fn/chaine-controller/create-chaine';
import { deleteChaine } from '../fn/chaine-controller/delete-chaine';
import { DeleteChaine$Params } from '../fn/chaine-controller/delete-chaine';
import { findAll6 } from '../fn/chaine-controller/find-all-6';
import { FindAll6$Params } from '../fn/chaine-controller/find-all-6';
import { findChaineById } from '../fn/chaine-controller/find-chaine-by-id';
import { FindChaineById$Params } from '../fn/chaine-controller/find-chaine-by-id';

@Injectable({ providedIn: 'root' })
export class ChaineControllerService extends BaseService {
  constructor(config: ApiConfiguration, http: HttpClient) {
    super(config, http);
  }

  /** Path part for operation `createChaine()` */
  static readonly CreateChainePath = '/api/order/chaine/creerChaine';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `createChaine()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  createChaine$Response(params: CreateChaine$Params, context?: HttpContext): Observable<StrictHttpResponse<Chaine>> {
    return createChaine(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `createChaine$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  createChaine(params: CreateChaine$Params, context?: HttpContext): Observable<Chaine> {
    return this.createChaine$Response(params, context).pipe(
      map((r: StrictHttpResponse<Chaine>): Chaine => r.body)
    );
  }

  /** Path part for operation `findChaineById()` */
  static readonly FindChaineByIdPath = '/api/order/chaine/find/by/{id}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `findChaineById()` instead.
   *
   * This method doesn't expect any request body.
   */
  findChaineById$Response(params: FindChaineById$Params, context?: HttpContext): Observable<StrictHttpResponse<ChaineValue>> {
    return findChaineById(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `findChaineById$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  findChaineById(params: FindChaineById$Params, context?: HttpContext): Observable<ChaineValue> {
    return this.findChaineById$Response(params, context).pipe(
      map((r: StrictHttpResponse<ChaineValue>): ChaineValue => r.body)
    );
  }

  /** Path part for operation `findAll6()` */
  static readonly FindAll6Path = '/api/order/chaine/find/all';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `findAll6()` instead.
   *
   * This method doesn't expect any request body.
   */
  findAll6$Response(params?: FindAll6$Params, context?: HttpContext): Observable<StrictHttpResponse<Array<ChaineValue>>> {
    return findAll6(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `findAll6$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  findAll6(params?: FindAll6$Params, context?: HttpContext): Observable<Array<ChaineValue>> {
    return this.findAll6$Response(params, context).pipe(
      map((r: StrictHttpResponse<Array<ChaineValue>>): Array<ChaineValue> => r.body)
    );
  }

  /** Path part for operation `deleteChaine()` */
  static readonly DeleteChainePath = '/api/order/chaine/delete/{id}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `deleteChaine()` instead.
   *
   * This method doesn't expect any request body.
   */
  deleteChaine$Response(params: DeleteChaine$Params, context?: HttpContext): Observable<StrictHttpResponse<void>> {
    return deleteChaine(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `deleteChaine$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  deleteChaine(params: DeleteChaine$Params, context?: HttpContext): Observable<void> {
    return this.deleteChaine$Response(params, context).pipe(
      map((r: StrictHttpResponse<void>): void => r.body)
    );
  }

}
