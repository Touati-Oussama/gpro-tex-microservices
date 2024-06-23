/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { ProduitValue } from '../../models/produit-value';

export interface FindProduitById$Params {
  id: number;
}

export function findProduitById(http: HttpClient, rootUrl: string, params: FindProduitById$Params, context?: HttpContext): Observable<StrictHttpResponse<ProduitValue>> {
  const rb = new RequestBuilder(rootUrl, findProduitById.PATH, 'get');
  if (params) {
    rb.path('id', params.id, {});
  }

  return http.request(
    rb.build({ responseType: 'blob', accept: '*/*', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<ProduitValue>;
    })
  );
}

findProduitById.PATH = '/api/produit/pd/find/by/{id}';
