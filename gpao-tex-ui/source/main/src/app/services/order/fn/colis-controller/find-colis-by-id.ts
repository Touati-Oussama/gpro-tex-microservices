/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { ColisValue } from '../../models/colis-value';

export interface FindColisById$Params {
  id: number;
}

export function findColisById(http: HttpClient, rootUrl: string, params: FindColisById$Params, context?: HttpContext): Observable<StrictHttpResponse<ColisValue>> {
  const rb = new RequestBuilder(rootUrl, findColisById.PATH, 'get');
  if (params) {
    rb.path('id', params.id, {});
  }

  return http.request(
    rb.build({ responseType: 'blob', accept: '*/*', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<ColisValue>;
    })
  );
}

findColisById.PATH = '/api/order/colis/find/by/{id}';
