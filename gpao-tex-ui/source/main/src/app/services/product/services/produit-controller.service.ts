/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { BaseService } from '../base-service';
import { ApiConfiguration } from '../api-configuration';
import { StrictHttpResponse } from '../strict-http-response';

import { createProduit } from '../fn/produit-controller/create-produit';
import { CreateProduit$Params } from '../fn/produit-controller/create-produit';
import { deletePd } from '../fn/produit-controller/delete-pd';
import { DeletePd$Params } from '../fn/produit-controller/delete-pd';
import { findAll4 } from '../fn/produit-controller/find-all-4';
import { FindAll4$Params } from '../fn/produit-controller/find-all-4';
import { findProduitById } from '../fn/produit-controller/find-produit-by-id';
import { FindProduitById$Params } from '../fn/produit-controller/find-produit-by-id';
import { Produit } from '../models/produit';
import { ProduitValue } from '../models/produit-value';
import { uploadProducts } from '../fn/produit-controller/upload-products';
import { UploadProducts$Params } from '../fn/produit-controller/upload-products';

@Injectable({ providedIn: 'root' })
export class ProduitControllerService extends BaseService {
  constructor(config: ApiConfiguration, http: HttpClient) {
    super(config, http);
  }

  /** Path part for operation `uploadProducts()` */
  static readonly UploadProductsPath = '/api/produit/pd/upload';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `uploadProducts()` instead.
   *
   * This method sends `multipart/form-data` and handles request body of type `multipart/form-data`.
   */
  uploadProducts$Response(params?: UploadProducts$Params, context?: HttpContext): Observable<StrictHttpResponse<number>> {
    return uploadProducts(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `uploadProducts$Response()` instead.
   *
   * This method sends `multipart/form-data` and handles request body of type `multipart/form-data`.
   */
  uploadProducts(params?: UploadProducts$Params, context?: HttpContext): Observable<number> {
    return this.uploadProducts$Response(params, context).pipe(
      map((r: StrictHttpResponse<number>): number => r.body)
    );
  }

  /** Path part for operation `createProduit()` */
  static readonly CreateProduitPath = '/api/produit/pd/creerCouleur';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `createProduit()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  createProduit$Response(params: CreateProduit$Params, context?: HttpContext): Observable<StrictHttpResponse<Produit>> {
    return createProduit(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `createProduit$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  createProduit(params: CreateProduit$Params, context?: HttpContext): Observable<Produit> {
    return this.createProduit$Response(params, context).pipe(
      map((r: StrictHttpResponse<Produit>): Produit => r.body)
    );
  }

  /** Path part for operation `findProduitById()` */
  static readonly FindProduitByIdPath = '/api/produit/pd/find/by/{id}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `findProduitById()` instead.
   *
   * This method doesn't expect any request body.
   */
  findProduitById$Response(params: FindProduitById$Params, context?: HttpContext): Observable<StrictHttpResponse<ProduitValue>> {
    return findProduitById(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `findProduitById$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  findProduitById(params: FindProduitById$Params, context?: HttpContext): Observable<ProduitValue> {
    return this.findProduitById$Response(params, context).pipe(
      map((r: StrictHttpResponse<ProduitValue>): ProduitValue => r.body)
    );
  }

  /** Path part for operation `findAll4()` */
  static readonly FindAll4Path = '/api/produit/pd/find/all';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `findAll4()` instead.
   *
   * This method doesn't expect any request body.
   */
  findAll4$Response(params?: FindAll4$Params, context?: HttpContext): Observable<StrictHttpResponse<Array<ProduitValue>>> {
    return findAll4(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `findAll4$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  findAll4(params?: FindAll4$Params, context?: HttpContext): Observable<Array<ProduitValue>> {
    return this.findAll4$Response(params, context).pipe(
      map((r: StrictHttpResponse<Array<ProduitValue>>): Array<ProduitValue> => r.body)
    );
  }

  /** Path part for operation `deletePd()` */
  static readonly DeletePdPath = '/api/produit/pd/delete/{id}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `deletePd()` instead.
   *
   * This method doesn't expect any request body.
   */
  deletePd$Response(params: DeletePd$Params, context?: HttpContext): Observable<StrictHttpResponse<void>> {
    return deletePd(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `deletePd$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  deletePd(params: DeletePd$Params, context?: HttpContext): Observable<void> {
    return this.deletePd$Response(params, context).pipe(
      map((r: StrictHttpResponse<void>): void => r.body)
    );
  }

}
