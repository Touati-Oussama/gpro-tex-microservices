/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { BaseService } from '../base-service';
import { ApiConfiguration } from '../api-configuration';
import { StrictHttpResponse } from '../strict-http-response';

import { createProdJour } from '../fn/production-jour-controller/create-prod-jour';
import { CreateProdJour$Params } from '../fn/production-jour-controller/create-prod-jour';
import { deleteProdJour } from '../fn/production-jour-controller/delete-prod-jour';
import { DeleteProdJour$Params } from '../fn/production-jour-controller/delete-prod-jour';
import { findAll } from '../fn/production-jour-controller/find-all';
import { FindAll$Params } from '../fn/production-jour-controller/find-all';
import { findProdJourById } from '../fn/production-jour-controller/find-prod-jour-by-id';
import { FindProdJourById$Params } from '../fn/production-jour-controller/find-prod-jour-by-id';
import { ProductionJour } from '../models/production-jour';
import { ProductionJourValue } from '../models/production-jour-value';

@Injectable({ providedIn: 'root' })
export class ProductionJourControllerService extends BaseService {
  constructor(config: ApiConfiguration, http: HttpClient) {
    super(config, http);
  }

  /** Path part for operation `createProdJour()` */
  static readonly CreateProdJourPath = '/api/production/prodJour/createProdJour';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `createProdJour()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  createProdJour$Response(params: CreateProdJour$Params, context?: HttpContext): Observable<StrictHttpResponse<ProductionJour>> {
    return createProdJour(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `createProdJour$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  createProdJour(params: CreateProdJour$Params, context?: HttpContext): Observable<ProductionJour> {
    return this.createProdJour$Response(params, context).pipe(
      map((r: StrictHttpResponse<ProductionJour>): ProductionJour => r.body)
    );
  }

  /** Path part for operation `findProdJourById()` */
  static readonly FindProdJourByIdPath = '/api/production/prodJour/find/by/{id}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `findProdJourById()` instead.
   *
   * This method doesn't expect any request body.
   */
  findProdJourById$Response(params: FindProdJourById$Params, context?: HttpContext): Observable<StrictHttpResponse<ProductionJourValue>> {
    return findProdJourById(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `findProdJourById$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  findProdJourById(params: FindProdJourById$Params, context?: HttpContext): Observable<ProductionJourValue> {
    return this.findProdJourById$Response(params, context).pipe(
      map((r: StrictHttpResponse<ProductionJourValue>): ProductionJourValue => r.body)
    );
  }

  /** Path part for operation `findAll()` */
  static readonly FindAllPath = '/api/production/prodJour/find/all';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `findAll()` instead.
   *
   * This method doesn't expect any request body.
   */
  findAll$Response(params?: FindAll$Params, context?: HttpContext): Observable<StrictHttpResponse<Array<ProductionJourValue>>> {
    return findAll(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `findAll$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  findAll(params?: FindAll$Params, context?: HttpContext): Observable<Array<ProductionJourValue>> {
    return this.findAll$Response(params, context).pipe(
      map((r: StrictHttpResponse<Array<ProductionJourValue>>): Array<ProductionJourValue> => r.body)
    );
  }

  /** Path part for operation `deleteProdJour()` */
  static readonly DeleteProdJourPath = '/api/production/prodJour/delete/{id}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `deleteProdJour()` instead.
   *
   * This method doesn't expect any request body.
   */
  deleteProdJour$Response(params: DeleteProdJour$Params, context?: HttpContext): Observable<StrictHttpResponse<void>> {
    return deleteProdJour(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `deleteProdJour$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  deleteProdJour(params: DeleteProdJour$Params, context?: HttpContext): Observable<void> {
    return this.deleteProdJour$Response(params, context).pipe(
      map((r: StrictHttpResponse<void>): void => r.body)
    );
  }

}
