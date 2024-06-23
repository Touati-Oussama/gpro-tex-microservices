/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { BaseService } from '../base-service';
import { ApiConfiguration } from '../api-configuration';
import { StrictHttpResponse } from '../strict-http-response';

import { createPilotageEfficience } from '../fn/pilotage-efficience-controller/create-pilotage-efficience';
import { CreatePilotageEfficience$Params } from '../fn/pilotage-efficience-controller/create-pilotage-efficience';
import { deletePe } from '../fn/pilotage-efficience-controller/delete-pe';
import { DeletePe$Params } from '../fn/pilotage-efficience-controller/delete-pe';
import { findAll3 } from '../fn/pilotage-efficience-controller/find-all-3';
import { FindAll3$Params } from '../fn/pilotage-efficience-controller/find-all-3';
import { findPeById } from '../fn/pilotage-efficience-controller/find-pe-by-id';
import { FindPeById$Params } from '../fn/pilotage-efficience-controller/find-pe-by-id';
import { PilotageEfficience } from '../models/pilotage-efficience';
import { PilotageEfficienceValue } from '../models/pilotage-efficience-value';

@Injectable({ providedIn: 'root' })
export class PilotageEfficienceControllerService extends BaseService {
  constructor(config: ApiConfiguration, http: HttpClient) {
    super(config, http);
  }

  /** Path part for operation `createPilotageEfficience()` */
  static readonly CreatePilotageEfficiencePath = '/api/produit/pilotage/createPilotageEfficience';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `createPilotageEfficience()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  createPilotageEfficience$Response(params: CreatePilotageEfficience$Params, context?: HttpContext): Observable<StrictHttpResponse<PilotageEfficience>> {
    return createPilotageEfficience(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `createPilotageEfficience$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  createPilotageEfficience(params: CreatePilotageEfficience$Params, context?: HttpContext): Observable<PilotageEfficience> {
    return this.createPilotageEfficience$Response(params, context).pipe(
      map((r: StrictHttpResponse<PilotageEfficience>): PilotageEfficience => r.body)
    );
  }

  /** Path part for operation `findPeById()` */
  static readonly FindPeByIdPath = '/api/produit/pilotage/find/by/{id}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `findPeById()` instead.
   *
   * This method doesn't expect any request body.
   */
  findPeById$Response(params: FindPeById$Params, context?: HttpContext): Observable<StrictHttpResponse<PilotageEfficienceValue>> {
    return findPeById(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `findPeById$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  findPeById(params: FindPeById$Params, context?: HttpContext): Observable<PilotageEfficienceValue> {
    return this.findPeById$Response(params, context).pipe(
      map((r: StrictHttpResponse<PilotageEfficienceValue>): PilotageEfficienceValue => r.body)
    );
  }

  /** Path part for operation `findAll3()` */
  static readonly FindAll3Path = '/api/produit/pilotage/find/all';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `findAll3()` instead.
   *
   * This method doesn't expect any request body.
   */
  findAll3$Response(params?: FindAll3$Params, context?: HttpContext): Observable<StrictHttpResponse<Array<PilotageEfficienceValue>>> {
    return findAll3(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `findAll3$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  findAll3(params?: FindAll3$Params, context?: HttpContext): Observable<Array<PilotageEfficienceValue>> {
    return this.findAll3$Response(params, context).pipe(
      map((r: StrictHttpResponse<Array<PilotageEfficienceValue>>): Array<PilotageEfficienceValue> => r.body)
    );
  }

  /** Path part for operation `deletePe()` */
  static readonly DeletePePath = '/api/produit/pilotage/delete/{id}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `deletePe()` instead.
   *
   * This method doesn't expect any request body.
   */
  deletePe$Response(params: DeletePe$Params, context?: HttpContext): Observable<StrictHttpResponse<void>> {
    return deletePe(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `deletePe$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  deletePe(params: DeletePe$Params, context?: HttpContext): Observable<void> {
    return this.deletePe$Response(params, context).pipe(
      map((r: StrictHttpResponse<void>): void => r.body)
    );
  }

}
