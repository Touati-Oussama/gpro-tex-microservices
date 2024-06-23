/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { BaseService } from '../base-service';
import { ApiConfiguration } from '../api-configuration';
import { StrictHttpResponse } from '../strict-http-response';

import { createProdHeureDetails } from '../fn/production-heure-details-controller/create-prod-heure-details';
import { CreateProdHeureDetails$Params } from '../fn/production-heure-details-controller/create-prod-heure-details';
import { deleteProdHeureDetails } from '../fn/production-heure-details-controller/delete-prod-heure-details';
import { DeleteProdHeureDetails$Params } from '../fn/production-heure-details-controller/delete-prod-heure-details';
import { findAll1 } from '../fn/production-heure-details-controller/find-all-1';
import { FindAll1$Params } from '../fn/production-heure-details-controller/find-all-1';
import { findProdHeureDetailsById } from '../fn/production-heure-details-controller/find-prod-heure-details-by-id';
import { FindProdHeureDetailsById$Params } from '../fn/production-heure-details-controller/find-prod-heure-details-by-id';
import { ProductionHeureDetails } from '../models/production-heure-details';
import { ProductionHeureDetailsValue } from '../models/production-heure-details-value';

@Injectable({ providedIn: 'root' })
export class ProductionHeureDetailsControllerService extends BaseService {
  constructor(config: ApiConfiguration, http: HttpClient) {
    super(config, http);
  }

  /** Path part for operation `createProdHeureDetails()` */
  static readonly CreateProdHeureDetailsPath = '/api/production/prodHeureDetails/createProdHeureDetails';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `createProdHeureDetails()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  createProdHeureDetails$Response(params: CreateProdHeureDetails$Params, context?: HttpContext): Observable<StrictHttpResponse<ProductionHeureDetails>> {
    return createProdHeureDetails(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `createProdHeureDetails$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  createProdHeureDetails(params: CreateProdHeureDetails$Params, context?: HttpContext): Observable<ProductionHeureDetails> {
    return this.createProdHeureDetails$Response(params, context).pipe(
      map((r: StrictHttpResponse<ProductionHeureDetails>): ProductionHeureDetails => r.body)
    );
  }

  /** Path part for operation `findProdHeureDetailsById()` */
  static readonly FindProdHeureDetailsByIdPath = '/api/production/prodHeureDetails/find/by/{id}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `findProdHeureDetailsById()` instead.
   *
   * This method doesn't expect any request body.
   */
  findProdHeureDetailsById$Response(params: FindProdHeureDetailsById$Params, context?: HttpContext): Observable<StrictHttpResponse<ProductionHeureDetailsValue>> {
    return findProdHeureDetailsById(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `findProdHeureDetailsById$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  findProdHeureDetailsById(params: FindProdHeureDetailsById$Params, context?: HttpContext): Observable<ProductionHeureDetailsValue> {
    return this.findProdHeureDetailsById$Response(params, context).pipe(
      map((r: StrictHttpResponse<ProductionHeureDetailsValue>): ProductionHeureDetailsValue => r.body)
    );
  }

  /** Path part for operation `findAll1()` */
  static readonly FindAll1Path = '/api/production/prodHeureDetails/find/all';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `findAll1()` instead.
   *
   * This method doesn't expect any request body.
   */
  findAll1$Response(params?: FindAll1$Params, context?: HttpContext): Observable<StrictHttpResponse<Array<ProductionHeureDetailsValue>>> {
    return findAll1(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `findAll1$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  findAll1(params?: FindAll1$Params, context?: HttpContext): Observable<Array<ProductionHeureDetailsValue>> {
    return this.findAll1$Response(params, context).pipe(
      map((r: StrictHttpResponse<Array<ProductionHeureDetailsValue>>): Array<ProductionHeureDetailsValue> => r.body)
    );
  }

  /** Path part for operation `deleteProdHeureDetails()` */
  static readonly DeleteProdHeureDetailsPath = '/api/production/prodHeureDetails/delete/{id}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `deleteProdHeureDetails()` instead.
   *
   * This method doesn't expect any request body.
   */
  deleteProdHeureDetails$Response(params: DeleteProdHeureDetails$Params, context?: HttpContext): Observable<StrictHttpResponse<void>> {
    return deleteProdHeureDetails(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `deleteProdHeureDetails$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  deleteProdHeureDetails(params: DeleteProdHeureDetails$Params, context?: HttpContext): Observable<void> {
    return this.deleteProdHeureDetails$Response(params, context).pipe(
      map((r: StrictHttpResponse<void>): void => r.body)
    );
  }

}
