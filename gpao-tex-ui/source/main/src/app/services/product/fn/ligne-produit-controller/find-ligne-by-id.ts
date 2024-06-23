/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { LigneProduitValue } from '../../models/ligne-produit-value';

export interface FindLigneById$Params {
  id: number;
}

export function findLigneById(http: HttpClient, rootUrl: string, params: FindLigneById$Params, context?: HttpContext): Observable<StrictHttpResponse<LigneProduitValue>> {
  const rb = new RequestBuilder(rootUrl, findLigneById.PATH, 'get');
  if (params) {
    rb.path('id', params.id, {});
  }

  return http.request(
    rb.build({ responseType: 'blob', accept: '*/*', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<LigneProduitValue>;
    })
  );
}

findLigneById.PATH = '/api/produit/ligne/find/by/{id}';
