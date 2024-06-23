/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { CapaciteSemaineValue } from '../../models/capacite-semaine-value';

export interface FindCsById$Params {
  id: number;
}

export function findCsById(http: HttpClient, rootUrl: string, params: FindCsById$Params, context?: HttpContext): Observable<StrictHttpResponse<CapaciteSemaineValue>> {
  const rb = new RequestBuilder(rootUrl, findCsById.PATH, 'get');
  if (params) {
    rb.path('id', params.id, {});
  }

  return http.request(
    rb.build({ responseType: 'blob', accept: '*/*', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<CapaciteSemaineValue>;
    })
  );
}

findCsById.PATH = '/api/order/capaciteSemaine/find/by/{id}';
