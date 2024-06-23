/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { BaseService } from '../base-service';
import { ApiConfiguration } from '../api-configuration';
import { StrictHttpResponse } from '../strict-http-response';

import { createLigne } from '../fn/ligne-produit-controller/create-ligne';
import { CreateLigne$Params } from '../fn/ligne-produit-controller/create-ligne';
import { deleteLigne } from '../fn/ligne-produit-controller/delete-ligne';
import { DeleteLigne$Params } from '../fn/ligne-produit-controller/delete-ligne';
import { findAll5 } from '../fn/ligne-produit-controller/find-all-5';
import { FindAll5$Params } from '../fn/ligne-produit-controller/find-all-5';
import { findLigneById } from '../fn/ligne-produit-controller/find-ligne-by-id';
import { FindLigneById$Params } from '../fn/ligne-produit-controller/find-ligne-by-id';
import { LigneProduit } from '../models/ligne-produit';
import { LigneProduitValue } from '../models/ligne-produit-value';

@Injectable({ providedIn: 'root' })
export class LigneProduitControllerService extends BaseService {
  constructor(config: ApiConfiguration, http: HttpClient) {
    super(config, http);
  }

  /** Path part for operation `createLigne()` */
  static readonly CreateLignePath = '/api/produit/ligne/createLigne';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `createLigne()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  createLigne$Response(params: CreateLigne$Params, context?: HttpContext): Observable<StrictHttpResponse<LigneProduit>> {
    return createLigne(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `createLigne$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  createLigne(params: CreateLigne$Params, context?: HttpContext): Observable<LigneProduit> {
    return this.createLigne$Response(params, context).pipe(
      map((r: StrictHttpResponse<LigneProduit>): LigneProduit => r.body)
    );
  }

  /** Path part for operation `findLigneById()` */
  static readonly FindLigneByIdPath = '/api/produit/ligne/find/by/{id}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `findLigneById()` instead.
   *
   * This method doesn't expect any request body.
   */
  findLigneById$Response(params: FindLigneById$Params, context?: HttpContext): Observable<StrictHttpResponse<LigneProduitValue>> {
    return findLigneById(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `findLigneById$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  findLigneById(params: FindLigneById$Params, context?: HttpContext): Observable<LigneProduitValue> {
    return this.findLigneById$Response(params, context).pipe(
      map((r: StrictHttpResponse<LigneProduitValue>): LigneProduitValue => r.body)
    );
  }

  /** Path part for operation `findAll5()` */
  static readonly FindAll5Path = '/api/produit/ligne/find/all';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `findAll5()` instead.
   *
   * This method doesn't expect any request body.
   */
  findAll5$Response(params?: FindAll5$Params, context?: HttpContext): Observable<StrictHttpResponse<Array<LigneProduitValue>>> {
    return findAll5(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `findAll5$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  findAll5(params?: FindAll5$Params, context?: HttpContext): Observable<Array<LigneProduitValue>> {
    return this.findAll5$Response(params, context).pipe(
      map((r: StrictHttpResponse<Array<LigneProduitValue>>): Array<LigneProduitValue> => r.body)
    );
  }

  /** Path part for operation `deleteLigne()` */
  static readonly DeleteLignePath = '/api/produit/ligne/delete/{id}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `deleteLigne()` instead.
   *
   * This method doesn't expect any request body.
   */
  deleteLigne$Response(params: DeleteLigne$Params, context?: HttpContext): Observable<StrictHttpResponse<void>> {
    return deleteLigne(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `deleteLigne$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  deleteLigne(params: DeleteLigne$Params, context?: HttpContext): Observable<void> {
    return this.deleteLigne$Response(params, context).pipe(
      map((r: StrictHttpResponse<void>): void => r.body)
    );
  }

}
