/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { BaseService } from '../base-service';
import { ApiConfiguration } from '../api-configuration';
import { StrictHttpResponse } from '../strict-http-response';

import { createProdHeure } from '../fn/production-heure-controller/create-prod-heure';
import { CreateProdHeure$Params } from '../fn/production-heure-controller/create-prod-heure';
import { deleteProdHeure } from '../fn/production-heure-controller/delete-prod-heure';
import { DeleteProdHeure$Params } from '../fn/production-heure-controller/delete-prod-heure';
import { findAll2 } from '../fn/production-heure-controller/find-all-2';
import { FindAll2$Params } from '../fn/production-heure-controller/find-all-2';
import { findProdHeureById } from '../fn/production-heure-controller/find-prod-heure-by-id';
import { FindProdHeureById$Params } from '../fn/production-heure-controller/find-prod-heure-by-id';
import { ProductionHeure } from '../models/production-heure';
import { ProductionHeureValue } from '../models/production-heure-value';

@Injectable({ providedIn: 'root' })
export class ProductionHeureControllerService extends BaseService {
  constructor(config: ApiConfiguration, http: HttpClient) {
    super(config, http);
  }

  /** Path part for operation `createProdHeure()` */
  static readonly CreateProdHeurePath = '/api/production/prodHeure/createProdHeure';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `createProdHeure()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  createProdHeure$Response(params: CreateProdHeure$Params, context?: HttpContext): Observable<StrictHttpResponse<ProductionHeure>> {
    return createProdHeure(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `createProdHeure$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  createProdHeure(params: CreateProdHeure$Params, context?: HttpContext): Observable<ProductionHeure> {
    return this.createProdHeure$Response(params, context).pipe(
      map((r: StrictHttpResponse<ProductionHeure>): ProductionHeure => r.body)
    );
  }

  /** Path part for operation `findProdHeureById()` */
  static readonly FindProdHeureByIdPath = '/api/production/prodHeure/find/by/{id}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `findProdHeureById()` instead.
   *
   * This method doesn't expect any request body.
   */
  findProdHeureById$Response(params: FindProdHeureById$Params, context?: HttpContext): Observable<StrictHttpResponse<ProductionHeureValue>> {
    return findProdHeureById(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `findProdHeureById$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  findProdHeureById(params: FindProdHeureById$Params, context?: HttpContext): Observable<ProductionHeureValue> {
    return this.findProdHeureById$Response(params, context).pipe(
      map((r: StrictHttpResponse<ProductionHeureValue>): ProductionHeureValue => r.body)
    );
  }

  /** Path part for operation `findAll2()` */
  static readonly FindAll2Path = '/api/production/prodHeure/find/all';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `findAll2()` instead.
   *
   * This method doesn't expect any request body.
   */
  findAll2$Response(params?: FindAll2$Params, context?: HttpContext): Observable<StrictHttpResponse<Array<ProductionHeureValue>>> {
    return findAll2(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `findAll2$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  findAll2(params?: FindAll2$Params, context?: HttpContext): Observable<Array<ProductionHeureValue>> {
    return this.findAll2$Response(params, context).pipe(
      map((r: StrictHttpResponse<Array<ProductionHeureValue>>): Array<ProductionHeureValue> => r.body)
    );
  }

  /** Path part for operation `deleteProdHeure()` */
  static readonly DeleteProdHeurePath = '/api/production/prodHeure/delete/{id}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `deleteProdHeure()` instead.
   *
   * This method doesn't expect any request body.
   */
  deleteProdHeure$Response(params: DeleteProdHeure$Params, context?: HttpContext): Observable<StrictHttpResponse<void>> {
    return deleteProdHeure(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `deleteProdHeure$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  deleteProdHeure(params: DeleteProdHeure$Params, context?: HttpContext): Observable<void> {
    return this.deleteProdHeure$Response(params, context).pipe(
      map((r: StrictHttpResponse<void>): void => r.body)
    );
  }

}
