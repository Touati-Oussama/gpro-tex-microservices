/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { DetailOfValue } from '../../models/detail-of-value';

export interface FindDetailOfById$Params {
  id: number;
}

export function findDetailOfById(http: HttpClient, rootUrl: string, params: FindDetailOfById$Params, context?: HttpContext): Observable<StrictHttpResponse<DetailOfValue>> {
  const rb = new RequestBuilder(rootUrl, findDetailOfById.PATH, 'get');
  if (params) {
    rb.path('id', params.id, {});
  }

  return http.request(
    rb.build({ responseType: 'blob', accept: '*/*', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<DetailOfValue>;
    })
  );
}

findDetailOfById.PATH = '/api/order/detailsOf/find/by/{id}';
