/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { OrdreFabrication } from '../../models/ordre-fabrication';
import { OrdreFabricationValue } from '../../models/ordre-fabrication-value';

export interface CreateOf$Params {
      body: OrdreFabricationValue
}

export function createOf(http: HttpClient, rootUrl: string, params: CreateOf$Params, context?: HttpContext): Observable<StrictHttpResponse<OrdreFabrication>> {
  const rb = new RequestBuilder(rootUrl, createOf.PATH, 'post');
  if (params) {
    rb.body(params.body, 'application/json');
  }

  return http.request(
    rb.build({ responseType: 'blob', accept: '*/*', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<OrdreFabrication>;
    })
  );
}

createOf.PATH = '/api/order/of/createOf';
