/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { FicheColisageValue } from '../../models/fiche-colisage-value';

export interface FindFicheColisById$Params {
  id: number;
}

export function findFicheColisById(http: HttpClient, rootUrl: string, params: FindFicheColisById$Params, context?: HttpContext): Observable<StrictHttpResponse<FicheColisageValue>> {
  const rb = new RequestBuilder(rootUrl, findFicheColisById.PATH, 'get');
  if (params) {
    rb.path('id', params.id, {});
  }

  return http.request(
    rb.build({ responseType: 'blob', accept: '*/*', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<FicheColisageValue>;
    })
  );
}

findFicheColisById.PATH = '/api/order/ficheColi/find/by/{id}';
