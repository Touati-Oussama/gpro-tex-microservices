/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { BaseService } from '../base-service';
import { ApiConfiguration } from '../api-configuration';
import { StrictHttpResponse } from '../strict-http-response';

import { createOf } from '../fn/ordre-fabrication-controller/create-of';
import { CreateOf$Params } from '../fn/ordre-fabrication-controller/create-of';
import { deleteOf } from '../fn/ordre-fabrication-controller/delete-of';
import { DeleteOf$Params } from '../fn/ordre-fabrication-controller/delete-of';
import { findAll1 } from '../fn/ordre-fabrication-controller/find-all-1';
import { FindAll1$Params } from '../fn/ordre-fabrication-controller/find-all-1';
import { findOfById } from '../fn/ordre-fabrication-controller/find-of-by-id';
import { FindOfById$Params } from '../fn/ordre-fabrication-controller/find-of-by-id';
import { OrdreFabrication } from '../models/ordre-fabrication';
import { OrdreFabricationValue } from '../models/ordre-fabrication-value';

@Injectable({ providedIn: 'root' })
export class OrdreFabricationControllerService extends BaseService {
  constructor(config: ApiConfiguration, http: HttpClient) {
    super(config, http);
  }

  /** Path part for operation `createOf()` */
  static readonly CreateOfPath = '/api/order/of/createOf';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `createOf()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  createOf$Response(params: CreateOf$Params, context?: HttpContext): Observable<StrictHttpResponse<OrdreFabrication>> {
    return createOf(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `createOf$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  createOf(params: CreateOf$Params, context?: HttpContext): Observable<OrdreFabrication> {
    return this.createOf$Response(params, context).pipe(
      map((r: StrictHttpResponse<OrdreFabrication>): OrdreFabrication => r.body)
    );
  }

  /** Path part for operation `findOfById()` */
  static readonly FindOfByIdPath = '/api/order/of/find/by/{id}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `findOfById()` instead.
   *
   * This method doesn't expect any request body.
   */
  findOfById$Response(params: FindOfById$Params, context?: HttpContext): Observable<StrictHttpResponse<OrdreFabricationValue>> {
    return findOfById(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `findOfById$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  findOfById(params: FindOfById$Params, context?: HttpContext): Observable<OrdreFabricationValue> {
    return this.findOfById$Response(params, context).pipe(
      map((r: StrictHttpResponse<OrdreFabricationValue>): OrdreFabricationValue => r.body)
    );
  }

  /** Path part for operation `findAll1()` */
  static readonly FindAll1Path = '/api/order/of/find/all';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `findAll1()` instead.
   *
   * This method doesn't expect any request body.
   */
  findAll1$Response(params?: FindAll1$Params, context?: HttpContext): Observable<StrictHttpResponse<Array<OrdreFabricationValue>>> {
    return findAll1(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `findAll1$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  findAll1(params?: FindAll1$Params, context?: HttpContext): Observable<Array<OrdreFabricationValue>> {
    return this.findAll1$Response(params, context).pipe(
      map((r: StrictHttpResponse<Array<OrdreFabricationValue>>): Array<OrdreFabricationValue> => r.body)
    );
  }

  /** Path part for operation `deleteOf()` */
  static readonly DeleteOfPath = '/api/order/of/delete/{id}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `deleteOf()` instead.
   *
   * This method doesn't expect any request body.
   */
  deleteOf$Response(params: DeleteOf$Params, context?: HttpContext): Observable<StrictHttpResponse<void>> {
    return deleteOf(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `deleteOf$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  deleteOf(params: DeleteOf$Params, context?: HttpContext): Observable<void> {
    return this.deleteOf$Response(params, context).pipe(
      map((r: StrictHttpResponse<void>): void => r.body)
    );
  }

}
