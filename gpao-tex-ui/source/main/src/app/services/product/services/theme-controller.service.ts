/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { BaseService } from '../base-service';
import { ApiConfiguration } from '../api-configuration';
import { StrictHttpResponse } from '../strict-http-response';

import { createTheme } from '../fn/theme-controller/create-theme';
import { CreateTheme$Params } from '../fn/theme-controller/create-theme';
import { deleteTheme } from '../fn/theme-controller/delete-theme';
import { DeleteTheme$Params } from '../fn/theme-controller/delete-theme';
import { findAll } from '../fn/theme-controller/find-all';
import { FindAll$Params } from '../fn/theme-controller/find-all';
import { findThemeById } from '../fn/theme-controller/find-theme-by-id';
import { FindThemeById$Params } from '../fn/theme-controller/find-theme-by-id';
import { Theme } from '../models/theme';
import { ThemeValue } from '../models/theme-value';

@Injectable({ providedIn: 'root' })
export class ThemeControllerService extends BaseService {
  constructor(config: ApiConfiguration, http: HttpClient) {
    super(config, http);
  }

  /** Path part for operation `createTheme()` */
  static readonly CreateThemePath = '/api/produit/theme/createTheme';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `createTheme()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  createTheme$Response(params: CreateTheme$Params, context?: HttpContext): Observable<StrictHttpResponse<Theme>> {
    return createTheme(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `createTheme$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  createTheme(params: CreateTheme$Params, context?: HttpContext): Observable<Theme> {
    return this.createTheme$Response(params, context).pipe(
      map((r: StrictHttpResponse<Theme>): Theme => r.body)
    );
  }

  /** Path part for operation `findThemeById()` */
  static readonly FindThemeByIdPath = '/api/produit/theme/find/by/{id}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `findThemeById()` instead.
   *
   * This method doesn't expect any request body.
   */
  findThemeById$Response(params: FindThemeById$Params, context?: HttpContext): Observable<StrictHttpResponse<ThemeValue>> {
    return findThemeById(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `findThemeById$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  findThemeById(params: FindThemeById$Params, context?: HttpContext): Observable<ThemeValue> {
    return this.findThemeById$Response(params, context).pipe(
      map((r: StrictHttpResponse<ThemeValue>): ThemeValue => r.body)
    );
  }

  /** Path part for operation `findAll()` */
  static readonly FindAllPath = '/api/produit/theme/find/all';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `findAll()` instead.
   *
   * This method doesn't expect any request body.
   */
  findAll$Response(params?: FindAll$Params, context?: HttpContext): Observable<StrictHttpResponse<Array<ThemeValue>>> {
    return findAll(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `findAll$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  findAll(params?: FindAll$Params, context?: HttpContext): Observable<Array<ThemeValue>> {
    return this.findAll$Response(params, context).pipe(
      map((r: StrictHttpResponse<Array<ThemeValue>>): Array<ThemeValue> => r.body)
    );
  }

  /** Path part for operation `deleteTheme()` */
  static readonly DeleteThemePath = '/api/produit/theme/delete/{id}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `deleteTheme()` instead.
   *
   * This method doesn't expect any request body.
   */
  deleteTheme$Response(params: DeleteTheme$Params, context?: HttpContext): Observable<StrictHttpResponse<void>> {
    return deleteTheme(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `deleteTheme$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  deleteTheme(params: DeleteTheme$Params, context?: HttpContext): Observable<void> {
    return this.deleteTheme$Response(params, context).pipe(
      map((r: StrictHttpResponse<void>): void => r.body)
    );
  }

}
