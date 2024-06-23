/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { TailleValue } from '../../models/taille-value';

export interface FindTailleById$Params {
  id: number;
}

export function findTailleById(http: HttpClient, rootUrl: string, params: FindTailleById$Params, context?: HttpContext): Observable<StrictHttpResponse<TailleValue>> {
  const rb = new RequestBuilder(rootUrl, findTailleById.PATH, 'get');
  if (params) {
    rb.path('id', params.id, {});
  }

  return http.request(
    rb.build({ responseType: 'blob', accept: '*/*', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<TailleValue>;
    })
  );
}

findTailleById.PATH = '/api/produit/taille/find/by/{id}';
