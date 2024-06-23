/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { ChaineValue } from '../../models/chaine-value';

export interface FindChaineById$Params {
  id: number;
}

export function findChaineById(http: HttpClient, rootUrl: string, params: FindChaineById$Params, context?: HttpContext): Observable<StrictHttpResponse<ChaineValue>> {
  const rb = new RequestBuilder(rootUrl, findChaineById.PATH, 'get');
  if (params) {
    rb.path('id', params.id, {});
  }

  return http.request(
    rb.build({ responseType: 'blob', accept: '*/*', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<ChaineValue>;
    })
  );
}

findChaineById.PATH = '/api/order/chaine/find/by/{id}';
