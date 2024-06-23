/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { BaseService } from '../base-service';
import { ApiConfiguration } from '../api-configuration';
import { StrictHttpResponse } from '../strict-http-response';

import { createSite } from '../fn/site-controller/create-site';
import { CreateSite$Params } from '../fn/site-controller/create-site';
import { deleteSite } from '../fn/site-controller/delete-site';
import { DeleteSite$Params } from '../fn/site-controller/delete-site';
import { findAll2 } from '../fn/site-controller/find-all-2';
import { FindAll2$Params } from '../fn/site-controller/find-all-2';
import { findSiteById } from '../fn/site-controller/find-site-by-id';
import { FindSiteById$Params } from '../fn/site-controller/find-site-by-id';
import { Site } from '../models/site';
import { SiteValue } from '../models/site-value';

@Injectable({ providedIn: 'root' })
export class SiteControllerService extends BaseService {
  constructor(config: ApiConfiguration, http: HttpClient) {
    super(config, http);
  }

  /** Path part for operation `createSite()` */
  static readonly CreateSitePath = '/api/produit/site/createSite';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `createSite()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  createSite$Response(params: CreateSite$Params, context?: HttpContext): Observable<StrictHttpResponse<Site>> {
    return createSite(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `createSite$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  createSite(params: CreateSite$Params, context?: HttpContext): Observable<Site> {
    return this.createSite$Response(params, context).pipe(
      map((r: StrictHttpResponse<Site>): Site => r.body)
    );
  }

  /** Path part for operation `findSiteById()` */
  static readonly FindSiteByIdPath = '/api/produit/site/find/by/{id}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `findSiteById()` instead.
   *
   * This method doesn't expect any request body.
   */
  findSiteById$Response(params: FindSiteById$Params, context?: HttpContext): Observable<StrictHttpResponse<SiteValue>> {
    return findSiteById(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `findSiteById$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  findSiteById(params: FindSiteById$Params, context?: HttpContext): Observable<SiteValue> {
    return this.findSiteById$Response(params, context).pipe(
      map((r: StrictHttpResponse<SiteValue>): SiteValue => r.body)
    );
  }

  /** Path part for operation `findAll2()` */
  static readonly FindAll2Path = '/api/produit/site/find/all';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `findAll2()` instead.
   *
   * This method doesn't expect any request body.
   */
  findAll2$Response(params?: FindAll2$Params, context?: HttpContext): Observable<StrictHttpResponse<Array<SiteValue>>> {
    return findAll2(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `findAll2$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  findAll2(params?: FindAll2$Params, context?: HttpContext): Observable<Array<SiteValue>> {
    return this.findAll2$Response(params, context).pipe(
      map((r: StrictHttpResponse<Array<SiteValue>>): Array<SiteValue> => r.body)
    );
  }

  /** Path part for operation `deleteSite()` */
  static readonly DeleteSitePath = '/api/produit/site/delete/{id}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `deleteSite()` instead.
   *
   * This method doesn't expect any request body.
   */
  deleteSite$Response(params: DeleteSite$Params, context?: HttpContext): Observable<StrictHttpResponse<void>> {
    return deleteSite(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `deleteSite$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  deleteSite(params: DeleteSite$Params, context?: HttpContext): Observable<void> {
    return this.deleteSite$Response(params, context).pipe(
      map((r: StrictHttpResponse<void>): void => r.body)
    );
  }

}
