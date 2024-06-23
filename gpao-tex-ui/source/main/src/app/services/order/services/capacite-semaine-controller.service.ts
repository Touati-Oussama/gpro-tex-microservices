/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { BaseService } from '../base-service';
import { ApiConfiguration } from '../api-configuration';
import { StrictHttpResponse } from '../strict-http-response';

import { CapaciteSemaine } from '../models/capacite-semaine';
import { CapaciteSemaineValue } from '../models/capacite-semaine-value';
import { createCs } from '../fn/capacite-semaine-controller/create-cs';
import { CreateCs$Params } from '../fn/capacite-semaine-controller/create-cs';
import { deleteCs } from '../fn/capacite-semaine-controller/delete-cs';
import { DeleteCs$Params } from '../fn/capacite-semaine-controller/delete-cs';
import { findAll7 } from '../fn/capacite-semaine-controller/find-all-7';
import { FindAll7$Params } from '../fn/capacite-semaine-controller/find-all-7';
import { findCsById } from '../fn/capacite-semaine-controller/find-cs-by-id';
import { FindCsById$Params } from '../fn/capacite-semaine-controller/find-cs-by-id';

@Injectable({ providedIn: 'root' })
export class CapaciteSemaineControllerService extends BaseService {
  constructor(config: ApiConfiguration, http: HttpClient) {
    super(config, http);
  }

  /** Path part for operation `createCs()` */
  static readonly CreateCsPath = '/api/order/capaciteSemaine/creerCs';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `createCs()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  createCs$Response(params: CreateCs$Params, context?: HttpContext): Observable<StrictHttpResponse<CapaciteSemaine>> {
    return createCs(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `createCs$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  createCs(params: CreateCs$Params, context?: HttpContext): Observable<CapaciteSemaine> {
    return this.createCs$Response(params, context).pipe(
      map((r: StrictHttpResponse<CapaciteSemaine>): CapaciteSemaine => r.body)
    );
  }

  /** Path part for operation `findCsById()` */
  static readonly FindCsByIdPath = '/api/order/capaciteSemaine/find/by/{id}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `findCsById()` instead.
   *
   * This method doesn't expect any request body.
   */
  findCsById$Response(params: FindCsById$Params, context?: HttpContext): Observable<StrictHttpResponse<CapaciteSemaineValue>> {
    return findCsById(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `findCsById$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  findCsById(params: FindCsById$Params, context?: HttpContext): Observable<CapaciteSemaineValue> {
    return this.findCsById$Response(params, context).pipe(
      map((r: StrictHttpResponse<CapaciteSemaineValue>): CapaciteSemaineValue => r.body)
    );
  }

  /** Path part for operation `findAll7()` */
  static readonly FindAll7Path = '/api/order/capaciteSemaine/find/all';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `findAll7()` instead.
   *
   * This method doesn't expect any request body.
   */
  findAll7$Response(params?: FindAll7$Params, context?: HttpContext): Observable<StrictHttpResponse<Array<CapaciteSemaineValue>>> {
    return findAll7(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `findAll7$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  findAll7(params?: FindAll7$Params, context?: HttpContext): Observable<Array<CapaciteSemaineValue>> {
    return this.findAll7$Response(params, context).pipe(
      map((r: StrictHttpResponse<Array<CapaciteSemaineValue>>): Array<CapaciteSemaineValue> => r.body)
    );
  }

  /** Path part for operation `deleteCs()` */
  static readonly DeleteCsPath = '/api/order/capaciteSemaine/delete/{id}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `deleteCs()` instead.
   *
   * This method doesn't expect any request body.
   */
  deleteCs$Response(params: DeleteCs$Params, context?: HttpContext): Observable<StrictHttpResponse<void>> {
    return deleteCs(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `deleteCs$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  deleteCs(params: DeleteCs$Params, context?: HttpContext): Observable<void> {
    return this.deleteCs$Response(params, context).pipe(
      map((r: StrictHttpResponse<void>): void => r.body)
    );
  }

}
