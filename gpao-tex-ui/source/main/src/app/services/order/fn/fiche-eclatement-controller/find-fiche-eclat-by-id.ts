/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { FicheEclatementValue } from '../../models/fiche-eclatement-value';

export interface FindFicheEclatById$Params {
  id: number;
}

export function findFicheEclatById(http: HttpClient, rootUrl: string, params: FindFicheEclatById$Params, context?: HttpContext): Observable<StrictHttpResponse<FicheEclatementValue>> {
  const rb = new RequestBuilder(rootUrl, findFicheEclatById.PATH, 'get');
  if (params) {
    rb.path('id', params.id, {});
  }

  return http.request(
    rb.build({ responseType: 'blob', accept: '*/*', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<FicheEclatementValue>;
    })
  );
}

findFicheEclatById.PATH = '/api/order/ficheEclat/find/by/{id}';
