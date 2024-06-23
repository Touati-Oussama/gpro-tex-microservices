/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { DetailOf } from '../../models/detail-of';
import { DetailOfValue } from '../../models/detail-of-value';

export interface CreerDetailOf$Params {
      body: DetailOfValue
}

export function creerDetailOf(http: HttpClient, rootUrl: string, params: CreerDetailOf$Params, context?: HttpContext): Observable<StrictHttpResponse<DetailOf>> {
  const rb = new RequestBuilder(rootUrl, creerDetailOf.PATH, 'post');
  if (params) {
    rb.body(params.body, 'application/json');
  }

  return http.request(
    rb.build({ responseType: 'blob', accept: '*/*', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<DetailOf>;
    })
  );
}

creerDetailOf.PATH = '/api/order/detailsOf/creerDetailOf';
