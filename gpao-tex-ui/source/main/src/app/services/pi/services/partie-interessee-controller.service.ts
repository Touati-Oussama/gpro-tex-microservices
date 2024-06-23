/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { BaseService } from '../base-service';
import { ApiConfiguration } from '../api-configuration';
import { StrictHttpResponse } from '../strict-http-response';

import { createPi } from '../fn/partie-interessee-controller/create-pi';
import { CreatePi$Params } from '../fn/partie-interessee-controller/create-pi';
import { deletePi } from '../fn/partie-interessee-controller/delete-pi';
import { DeletePi$Params } from '../fn/partie-interessee-controller/delete-pi';
import { findAll } from '../fn/partie-interessee-controller/find-all';
import { FindAll$Params } from '../fn/partie-interessee-controller/find-all';
import { findPiById } from '../fn/partie-interessee-controller/find-pi-by-id';
import { FindPiById$Params } from '../fn/partie-interessee-controller/find-pi-by-id';
import { getAbbreviationClient } from '../fn/partie-interessee-controller/get-abbreviation-client';
import { GetAbbreviationClient$Params } from '../fn/partie-interessee-controller/get-abbreviation-client';
import { PartieInteresse } from '../models/partie-interesse';
import { PartieInteresseValue } from '../models/partie-interesse-value';

@Injectable({ providedIn: 'root' })
export class PartieInteresseeControllerService extends BaseService {
  constructor(config: ApiConfiguration, http: HttpClient) {
    super(config, http);
  }

  /** Path part for operation `createPi()` */
  static readonly CreatePiPath = '/api/operations/pi/creerPi';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `createPi()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  createPi$Response(params: CreatePi$Params, context?: HttpContext): Observable<StrictHttpResponse<PartieInteresse>> {
    return createPi(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `createPi$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  createPi(params: CreatePi$Params, context?: HttpContext): Observable<PartieInteresse> {
    return this.createPi$Response(params, context).pipe(
      map((r: StrictHttpResponse<PartieInteresse>): PartieInteresse => r.body)
    );
  }

  /** Path part for operation `findPiById()` */
  static readonly FindPiByIdPath = '/api/operations/pi/find/by/{id}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `findPiById()` instead.
   *
   * This method doesn't expect any request body.
   */
  findPiById$Response(params: FindPiById$Params, context?: HttpContext): Observable<StrictHttpResponse<PartieInteresseValue>> {
    return findPiById(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `findPiById$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  findPiById(params: FindPiById$Params, context?: HttpContext): Observable<PartieInteresseValue> {
    return this.findPiById$Response(params, context).pipe(
      map((r: StrictHttpResponse<PartieInteresseValue>): PartieInteresseValue => r.body)
    );
  }

  /** Path part for operation `findAll()` */
  static readonly FindAllPath = '/api/operations/pi/find/all';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `findAll()` instead.
   *
   * This method doesn't expect any request body.
   */
  findAll$Response(params?: FindAll$Params, context?: HttpContext): Observable<StrictHttpResponse<Array<PartieInteresseValue>>> {
    return findAll(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `findAll$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  findAll(params?: FindAll$Params, context?: HttpContext): Observable<Array<PartieInteresseValue>> {
    return this.findAll$Response(params, context).pipe(
      map((r: StrictHttpResponse<Array<PartieInteresseValue>>): Array<PartieInteresseValue> => r.body)
    );
  }

  /** Path part for operation `getAbbreviationClient()` */
  static readonly GetAbbreviationClientPath = '/api/operations/pi/AbreviationClient/{id}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `getAbbreviationClient()` instead.
   *
   * This method doesn't expect any request body.
   */
  getAbbreviationClient$Response(params: GetAbbreviationClient$Params, context?: HttpContext): Observable<StrictHttpResponse<PartieInteresseValue>> {
    return getAbbreviationClient(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `getAbbreviationClient$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  getAbbreviationClient(params: GetAbbreviationClient$Params, context?: HttpContext): Observable<PartieInteresseValue> {
    return this.getAbbreviationClient$Response(params, context).pipe(
      map((r: StrictHttpResponse<PartieInteresseValue>): PartieInteresseValue => r.body)
    );
  }

  /** Path part for operation `deletePi()` */
  static readonly DeletePiPath = '/api/operations/pi/delete/{id}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `deletePi()` instead.
   *
   * This method doesn't expect any request body.
   */
  deletePi$Response(params: DeletePi$Params, context?: HttpContext): Observable<StrictHttpResponse<void>> {
    return deletePi(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `deletePi$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  deletePi(params: DeletePi$Params, context?: HttpContext): Observable<void> {
    return this.deletePi$Response(params, context).pipe(
      map((r: StrictHttpResponse<void>): void => r.body)
    );
  }

}
