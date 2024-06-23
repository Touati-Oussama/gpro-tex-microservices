/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { BaseService } from '../base-service';
import { ApiConfiguration } from '../api-configuration';
import { StrictHttpResponse } from '../strict-http-response';

import { Colis } from '../models/colis';
import { ColisValue } from '../models/colis-value';
import { createColis } from '../fn/colis-controller/create-colis';
import { CreateColis$Params } from '../fn/colis-controller/create-colis';
import { deleteColis } from '../fn/colis-controller/delete-colis';
import { DeleteColis$Params } from '../fn/colis-controller/delete-colis';
import { findAll5 } from '../fn/colis-controller/find-all-5';
import { FindAll5$Params } from '../fn/colis-controller/find-all-5';
import { findColisById } from '../fn/colis-controller/find-colis-by-id';
import { FindColisById$Params } from '../fn/colis-controller/find-colis-by-id';

@Injectable({ providedIn: 'root' })
export class ColisControllerService extends BaseService {
  constructor(config: ApiConfiguration, http: HttpClient) {
    super(config, http);
  }

  /** Path part for operation `createColis()` */
  static readonly CreateColisPath = '/api/order/colis/creerChaine';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `createColis()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  createColis$Response(params: CreateColis$Params, context?: HttpContext): Observable<StrictHttpResponse<Colis>> {
    return createColis(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `createColis$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  createColis(params: CreateColis$Params, context?: HttpContext): Observable<Colis> {
    return this.createColis$Response(params, context).pipe(
      map((r: StrictHttpResponse<Colis>): Colis => r.body)
    );
  }

  /** Path part for operation `findColisById()` */
  static readonly FindColisByIdPath = '/api/order/colis/find/by/{id}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `findColisById()` instead.
   *
   * This method doesn't expect any request body.
   */
  findColisById$Response(params: FindColisById$Params, context?: HttpContext): Observable<StrictHttpResponse<ColisValue>> {
    return findColisById(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `findColisById$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  findColisById(params: FindColisById$Params, context?: HttpContext): Observable<ColisValue> {
    return this.findColisById$Response(params, context).pipe(
      map((r: StrictHttpResponse<ColisValue>): ColisValue => r.body)
    );
  }

  /** Path part for operation `findAll5()` */
  static readonly FindAll5Path = '/api/order/colis/find/all';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `findAll5()` instead.
   *
   * This method doesn't expect any request body.
   */
  findAll5$Response(params?: FindAll5$Params, context?: HttpContext): Observable<StrictHttpResponse<Array<ColisValue>>> {
    return findAll5(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `findAll5$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  findAll5(params?: FindAll5$Params, context?: HttpContext): Observable<Array<ColisValue>> {
    return this.findAll5$Response(params, context).pipe(
      map((r: StrictHttpResponse<Array<ColisValue>>): Array<ColisValue> => r.body)
    );
  }

  /** Path part for operation `deleteColis()` */
  static readonly DeleteColisPath = '/api/order/colis/delete/{id}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `deleteColis()` instead.
   *
   * This method doesn't expect any request body.
   */
  deleteColis$Response(params: DeleteColis$Params, context?: HttpContext): Observable<StrictHttpResponse<void>> {
    return deleteColis(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `deleteColis$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  deleteColis(params: DeleteColis$Params, context?: HttpContext): Observable<void> {
    return this.deleteColis$Response(params, context).pipe(
      map((r: StrictHttpResponse<void>): void => r.body)
    );
  }

}
