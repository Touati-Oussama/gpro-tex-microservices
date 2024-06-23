/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { BaseService } from '../base-service';
import { ApiConfiguration } from '../api-configuration';
import { StrictHttpResponse } from '../strict-http-response';

import { creerDetailOf } from '../fn/details-of-controller/creer-detail-of';
import { CreerDetailOf$Params } from '../fn/details-of-controller/creer-detail-of';
import { deleteDetailOf } from '../fn/details-of-controller/delete-detail-of';
import { DeleteDetailOf$Params } from '../fn/details-of-controller/delete-detail-of';
import { DetailOf } from '../models/detail-of';
import { DetailOfValue } from '../models/detail-of-value';
import { findAll4 } from '../fn/details-of-controller/find-all-4';
import { FindAll4$Params } from '../fn/details-of-controller/find-all-4';
import { findDetailOfById } from '../fn/details-of-controller/find-detail-of-by-id';
import { FindDetailOfById$Params } from '../fn/details-of-controller/find-detail-of-by-id';

@Injectable({ providedIn: 'root' })
export class DetailsOfControllerService extends BaseService {
  constructor(config: ApiConfiguration, http: HttpClient) {
    super(config, http);
  }

  /** Path part for operation `creerDetailOf()` */
  static readonly CreerDetailOfPath = '/api/order/detailsOf/creerDetailOf';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `creerDetailOf()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  creerDetailOf$Response(params: CreerDetailOf$Params, context?: HttpContext): Observable<StrictHttpResponse<DetailOf>> {
    return creerDetailOf(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `creerDetailOf$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  creerDetailOf(params: CreerDetailOf$Params, context?: HttpContext): Observable<DetailOf> {
    return this.creerDetailOf$Response(params, context).pipe(
      map((r: StrictHttpResponse<DetailOf>): DetailOf => r.body)
    );
  }

  /** Path part for operation `findDetailOfById()` */
  static readonly FindDetailOfByIdPath = '/api/order/detailsOf/find/by/{id}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `findDetailOfById()` instead.
   *
   * This method doesn't expect any request body.
   */
  findDetailOfById$Response(params: FindDetailOfById$Params, context?: HttpContext): Observable<StrictHttpResponse<DetailOfValue>> {
    return findDetailOfById(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `findDetailOfById$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  findDetailOfById(params: FindDetailOfById$Params, context?: HttpContext): Observable<DetailOfValue> {
    return this.findDetailOfById$Response(params, context).pipe(
      map((r: StrictHttpResponse<DetailOfValue>): DetailOfValue => r.body)
    );
  }

  /** Path part for operation `findAll4()` */
  static readonly FindAll4Path = '/api/order/detailsOf/find/all';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `findAll4()` instead.
   *
   * This method doesn't expect any request body.
   */
  findAll4$Response(params?: FindAll4$Params, context?: HttpContext): Observable<StrictHttpResponse<Array<DetailOfValue>>> {
    return findAll4(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `findAll4$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  findAll4(params?: FindAll4$Params, context?: HttpContext): Observable<Array<DetailOfValue>> {
    return this.findAll4$Response(params, context).pipe(
      map((r: StrictHttpResponse<Array<DetailOfValue>>): Array<DetailOfValue> => r.body)
    );
  }

  /** Path part for operation `deleteDetailOf()` */
  static readonly DeleteDetailOfPath = '/api/order/detailsOf/delete/{id}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `deleteDetailOf()` instead.
   *
   * This method doesn't expect any request body.
   */
  deleteDetailOf$Response(params: DeleteDetailOf$Params, context?: HttpContext): Observable<StrictHttpResponse<void>> {
    return deleteDetailOf(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `deleteDetailOf$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  deleteDetailOf(params: DeleteDetailOf$Params, context?: HttpContext): Observable<void> {
    return this.deleteDetailOf$Response(params, context).pipe(
      map((r: StrictHttpResponse<void>): void => r.body)
    );
  }

}
