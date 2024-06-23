/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { BaseService } from '../base-service';
import { ApiConfiguration } from '../api-configuration';
import { StrictHttpResponse } from '../strict-http-response';

import { createTaille } from '../fn/taille-controller/create-taille';
import { CreateTaille$Params } from '../fn/taille-controller/create-taille';
import { deleteTaille } from '../fn/taille-controller/delete-taille';
import { DeleteTaille$Params } from '../fn/taille-controller/delete-taille';
import { findAll1 } from '../fn/taille-controller/find-all-1';
import { FindAll1$Params } from '../fn/taille-controller/find-all-1';
import { findTailleById } from '../fn/taille-controller/find-taille-by-id';
import { FindTailleById$Params } from '../fn/taille-controller/find-taille-by-id';
import { Taille } from '../models/taille';
import { TailleValue } from '../models/taille-value';

@Injectable({ providedIn: 'root' })
export class TailleControllerService extends BaseService {
  constructor(config: ApiConfiguration, http: HttpClient) {
    super(config, http);
  }

  /** Path part for operation `createTaille()` */
  static readonly CreateTaillePath = '/api/produit/taille/createTaille';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `createTaille()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  createTaille$Response(params: CreateTaille$Params, context?: HttpContext): Observable<StrictHttpResponse<Taille>> {
    return createTaille(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `createTaille$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  createTaille(params: CreateTaille$Params, context?: HttpContext): Observable<Taille> {
    return this.createTaille$Response(params, context).pipe(
      map((r: StrictHttpResponse<Taille>): Taille => r.body)
    );
  }

  /** Path part for operation `findTailleById()` */
  static readonly FindTailleByIdPath = '/api/produit/taille/find/by/{id}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `findTailleById()` instead.
   *
   * This method doesn't expect any request body.
   */
  findTailleById$Response(params: FindTailleById$Params, context?: HttpContext): Observable<StrictHttpResponse<TailleValue>> {
    return findTailleById(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `findTailleById$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  findTailleById(params: FindTailleById$Params, context?: HttpContext): Observable<TailleValue> {
    return this.findTailleById$Response(params, context).pipe(
      map((r: StrictHttpResponse<TailleValue>): TailleValue => r.body)
    );
  }

  /** Path part for operation `findAll1()` */
  static readonly FindAll1Path = '/api/produit/taille/find/all';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `findAll1()` instead.
   *
   * This method doesn't expect any request body.
   */
  findAll1$Response(params?: FindAll1$Params, context?: HttpContext): Observable<StrictHttpResponse<Array<TailleValue>>> {
    return findAll1(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `findAll1$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  findAll1(params?: FindAll1$Params, context?: HttpContext): Observable<Array<TailleValue>> {
    return this.findAll1$Response(params, context).pipe(
      map((r: StrictHttpResponse<Array<TailleValue>>): Array<TailleValue> => r.body)
    );
  }

  /** Path part for operation `deleteTaille()` */
  static readonly DeleteTaillePath = '/api/produit/taille/delete/{id}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `deleteTaille()` instead.
   *
   * This method doesn't expect any request body.
   */
  deleteTaille$Response(params: DeleteTaille$Params, context?: HttpContext): Observable<StrictHttpResponse<void>> {
    return deleteTaille(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `deleteTaille$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  deleteTaille(params: DeleteTaille$Params, context?: HttpContext): Observable<void> {
    return this.deleteTaille$Response(params, context).pipe(
      map((r: StrictHttpResponse<void>): void => r.body)
    );
  }

}
