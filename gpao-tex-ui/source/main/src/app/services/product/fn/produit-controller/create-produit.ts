/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { Produit } from '../../models/produit';
import { ProduitValue } from '../../models/produit-value';

export interface CreateProduit$Params {
      body: ProduitValue
}

export function createProduit(http: HttpClient, rootUrl: string, params: CreateProduit$Params, context?: HttpContext): Observable<StrictHttpResponse<Produit>> {
  const rb = new RequestBuilder(rootUrl, createProduit.PATH, 'post');
  if (params) {
    rb.body(params.body, 'application/json');
  }

  return http.request(
    rb.build({ responseType: 'blob', accept: '*/*', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<Produit>;
    })
  );
}

createProduit.PATH = '/api/produit/pd/creerCouleur';
